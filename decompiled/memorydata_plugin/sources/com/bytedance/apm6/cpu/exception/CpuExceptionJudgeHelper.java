package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionJudgeHelper {
    private static String cacheScene;

    public CpuExceptionJudgeHelper() {
    }

    public static String getCacheScene() {
        return cacheScene;
    }

    public static void initScene(String r0) {
        cacheScene = r0;
    }

    public static boolean isForeMatchScene(CpuExceptionConfig r5) {
        if (r5.getForeSceneMaxSpeedMap().isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.getForeSceneMaxSpeedMap().containsKey(r2) == false) goto L7;
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

    public static boolean judge(CpuExceptionConfig r10, double r11, boolean r13) {
        if (r13 == false) goto L30;
        if (r10.getBackSceneMaxSpeedMap().isEmpty() == true) goto L19;
        Iterator<String> r14 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r5 = 0.0d;
    L8:
        if (r14.hasNext() == false) goto L21;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
        if (r10.getBackSceneMaxSpeedMap().containsKey(r7) == false) goto L8;
        double r8 = ((Double) ZeusTransformUtils.preCheckCast(r10.getBackSceneMaxSpeedMap().get(r7), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r8 < 0.0d) goto L8;
        if (r5 > r8) goto L8;
        r5 = r8;
    L21:
        if (r5 > 0.0d) goto L25;
        r5 = r10.getMaxProcessBackCpuSpeed();
    L25:
        if (r11 <= r5) goto L28;
        return true;
    L28:
        return false;
    L19:
        r5 = 0.0d;
        goto L21
    L30:
        if (r10.getForeSceneMaxSpeedMap().isEmpty() == true) goto L44;
        Iterator<String> r15 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r6 = 0.0d;
    L33:
        if (r15.hasNext() == false) goto L46;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r10.getForeSceneMaxSpeedMap().containsKey(r9) == false) goto L33;
        double r12 = ((Double) ZeusTransformUtils.preCheckCast(r10.getForeSceneMaxSpeedMap().get(r9), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r12 < 0.0d) goto L33;
        if (r6 > r12) goto L33;
        r6 = r12;
    L46:
        if (r6 > 0.0d) goto L50;
        r6 = r10.getMaxProcessForeCpuSpeed();
    L50:
        if (r11 <= r6) goto L53;
        return true;
    L53:
        return false;
    L44:
        r6 = 0.0d;
        goto L46
    }
}
