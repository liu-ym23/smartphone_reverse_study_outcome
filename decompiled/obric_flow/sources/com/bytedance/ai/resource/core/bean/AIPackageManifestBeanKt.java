package com.bytedance.ai.resource.core.bean;

import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ai-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAIPackageManifestBean.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AIPackageManifestBean.kt\ncom/bytedance/ai/resource/core/bean/AIPackageManifestBeanKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,180:1\n1863#2:181\n1557#2:182\n1628#2,3:183\n1864#2:186\n*S KotlinDebug\n*F\n+ 1 AIPackageManifestBean.kt\ncom/bytedance/ai/resource/core/bean/AIPackageManifestBeanKt\n*L\n142#1:181\n171#1:182\n171#1:183,3\n142#1:186\n*E\n"})
public abstract class AIPackageManifestBeanKt {
    public static final Applet a(AIPackageManifestBean r24) {
        Intrinsics.checkNotNullParameter(r24, "<this>");
        AIPackageManifestBean.AppletBean r5 = r24.getApplet();
        if (r5 == null) goto L9;
        String r10 = r5.getName();
        String r11 = r24.getPackageName();
        long r12 = r24.getVersionCode();
        String r13 = r24.getScmVersion();
        String r14 = r24.getVersionName();
        String r15 = r5.getDescription();
        Icons r16 = r5.getIcons();
        String r17 = r24.getManifestVersion();
        String r18 = r5.getProp();
        String r19 = r5.getRecommend();
        List<String> r110 = r5.getKeywords();
        String r111 = r5.getAppGroup();
        String r112 = r5.getAppletId();
        ArrayList<Page> r113 = r5.getPages();
        ArrayList<Plugin> r114 = r5.getPlugins();
        String r20 = r5.getBotId();
        String r21 = r5.getAppletEntry();
        String r22 = r5.getAppRuntimeEntry();
        String r23 = r24.getRuntimeVersion();
        if (r23 != null) goto L7;
        r23 = "";
    L7:
        Applet r115 = new Applet(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21, r22, r23);
        String r25 = r5.getDigest();
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r115.f2267n = r25;
        String r26 = r24.getRenderType();
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        r115.f2268o = r26;
        String r27 = r5.getBotDevMode();
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r115.L = r27;
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r115.f2274v = "installed";
        r115.R = r24.getPermissions();
        return r115;
    L9:
        return null;
    }

    public static final ArrayList b(AIPackageManifestBean r29) {
        Intrinsics.checkNotNullParameter(r29, "<this>");
        List<AIPackageManifestBean.WidgetsBean> r5 = r29.getWidgets();
        if (r5 == null) goto L20;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L6:
        if (r11.hasNext() == false) goto L19;
        AIPackageManifestBean.WidgetsBean r12 = (AIPackageManifestBean.WidgetsBean) r11.next();
        String r13 = r12.getName();
        String r14 = r29.getPackageName();
        long r15 = r29.getVersionCode();
        String r16 = r29.getVersionName();
        String r17 = r12.getDescription();
        Icons r18 = r12.getIcons();
        String r19 = r29.getManifestVersion();
        String r110 = r12.getProp();
        String r111 = r12.getRecommend();
        List<String> r112 = r12.getKeywords();
        String r113 = r12.getAppGroup();
        String r114 = r12.getWidgetId();
        String r20 = r12.getEntry();
        String r21 = r12.getInput();
        String r22 = r12.getOutput();
        boolean r23 = r12.getBorder();
        int r24 = r12.getBoxType();
        Integer r25 = Integer.valueOf(r12.getTitleType());
        String r26 = r29.getRuntimeVersion();
        if (r26 != null) goto L10;
        r26 = "";
    L10:
        Widget r115 = new Widget(r13, r14, r15, null, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, 8);
        String r27 = r12.getDigest();
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r115.f2267n = r27;
        if (c.l(r12.getRenderType()) == false) goto L13;
        String r28 = r12.getRenderType();
    L14:
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r115.f2268o = r28;
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r115.f2274v = "installed";
        List<AIPackageManifestBean.AppSettingsBean> r30 = r12.getAppSettings();
        ArrayList r31 = new ArrayList(CollectionsKt.h(r30));
        Iterator<T> r32 = r30.iterator();
    L16:
        if (r32.hasNext() == false) goto L18;
        r31.add(((AIPackageManifestBean.AppSettingsBean) r32.next()).getKey());
        goto L16
    L18:
        Intrinsics.checkNotNullParameter(r31, "<set-?>");
        r115.O = r31;
        r10.add(r115);
        goto L6
    L13:
        r28 = r29.getRenderType();
        goto L14
    L19:
        return r10;
    L20:
        return null;
    }
}
