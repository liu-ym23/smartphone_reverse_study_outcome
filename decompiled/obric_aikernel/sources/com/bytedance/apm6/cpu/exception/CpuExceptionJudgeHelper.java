package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionJudgeHelper {
    private static String cacheScene;

    public CpuExceptionJudgeHelper() {
    }

    public static String getCacheScene() {
        return cacheScene;
    }

    public static void initScene(String r10) {
        cacheScene = r10;
    }

    public static boolean isForeMatchScene(CpuExceptionConfig r10) {
        if (r10.getForeSceneMaxSpeedMap().isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<String> r11 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();
        if (r10.getForeSceneMaxSpeedMap().containsKey(r12) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static boolean isNeedSkipJudge() {
        return isSceneChanged();
    }

    private static boolean isSceneChanged() {
        cacheScene = ApmCpuManager.getInstance().getCpuSceneString();
        return false;
    }

    public static boolean judge(CpuExceptionConfig r10, double r11, boolean r12) {
        if (r12 == false) goto L30;
        if (r10.getBackSceneMaxSpeedMap().isEmpty() == true) goto L19;
        Iterator<String> r13 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r14 = 0.0d;
    L8:
        if (r13.hasNext() == false) goto L21;
        String r15 = r13.next();
        if (r10.getBackSceneMaxSpeedMap().containsKey(r15) == false) goto L8;
        double r16 = r10.getBackSceneMaxSpeedMap().get(r15).doubleValue();
        if (r16 < 0.0d) goto L8;
        if (r14 > r16) goto L8;
        r14 = r16;
    L21:
        if (r14 > 0.0d) goto L25;
        r14 = r10.getMaxProcessBackCpuSpeed();
    L25:
        if (r11 <= r14) goto L28;
        return true;
    L28:
        return false;
    L19:
        r14 = 0.0d;
        goto L21
    L30:
        if (r10.getForeSceneMaxSpeedMap().isEmpty() == true) goto L44;
        Iterator<String> r17 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r18 = 0.0d;
    L33:
        if (r17.hasNext() == false) goto L46;
        String r19 = r17.next();
        if (r10.getForeSceneMaxSpeedMap().containsKey(r19) == false) goto L33;
        double r20 = r10.getForeSceneMaxSpeedMap().get(r19).doubleValue();
        if (r20 < 0.0d) goto L33;
        if (r18 > r20) goto L33;
        r18 = r20;
    L46:
        if (r18 > 0.0d) goto L50;
        r18 = r10.getMaxProcessForeCpuSpeed();
    L50:
        if (r11 <= r18) goto L53;
        return true;
    L53:
        return false;
    L44:
        r18 = 0.0d;
        goto L46
    }
}
