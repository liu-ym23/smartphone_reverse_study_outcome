package com.bytedance.ai.resource.core.bean;

import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.AppletSettings;
import com.bytedance.ai.model.objects.Icons;
import com.bytedance.ai.model.objects.Page;
import com.bytedance.ai.model.objects.Plugin;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.utils.f;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final Applet a(AIPackageManifestBean r25) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        AIPackageManifestBean.AppletBean r0 = r25.getApplet();
        if (r0 == null) goto L25;
        String r10 = r0.getName();
        String r11 = r25.getPackageName();
        long r12 = r25.getVersionCode();
        String r13 = r25.getScmVersion();
        String r14 = r25.getVersionName();
        String r15 = r0.getDescription();
        Icons r16 = r0.getIcons();
        String r17 = r25.getManifestVersion();
        String r18 = r0.getProp();
        String r19 = r0.getRecommend();
        List<String> r110 = r0.getKeywords();
        String r111 = r0.getAppGroup();
        String r112 = r0.getAppletId();
        ArrayList<Page> r113 = r0.getPages();
        ArrayList<Plugin> r20 = r0.getPlugins();
        String r21 = r0.getBotId();
        String r22 = r0.getAppletEntry();
        String r23 = r0.getAppRuntimeEntry();
        String r24 = r25.getRuntimeVersion();
        if (r24 != null) goto L7;
        r24 = "";
    L7:
        Applet r114 = new Applet(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24);
        r114.Z = r0.getToolRuntimeEntry();
        r114.i(r0.getDigest());
        r114.k(r25.getRenderType());
        r114.r(r0.getBotDevMode());
        Boolean r26 = r0.getDarkMode();
        if (r26 == null) goto L10;
        boolean r27 = r26.booleanValue();
    L11:
        r114.X = r27;
        r114.Y = r0.getChat();
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r114.v = "installed";
        r114.W = r25.getPermissions();
        Integer r1 = r25.getAppType();
        if (r1 == null) goto L14;
        int r28 = r1.intValue();
    L15:
        r114.F = r28;
        Integer r29 = r25.getSourceType();
        if (r29 == null) goto L18;
        int r30 = r29.intValue();
    L19:
        r114.G = r30;
        AIPackageManifestBean.SettingsBean r31 = r25.getSettings();
        if (r31 == null) goto L22;
        AppletSettings r32 = new AppletSettings();
        r32.setUrlCheck(r31.getUrlCheck());
    L23:
        r114.k0 = r32;
        return r114;
    L22:
        r32 = null;
        goto L23
    L18:
        r30 = 2;
        goto L19
    L14:
        r28 = CastIntegerProtector.parseInt("1");
        goto L15
    L10:
        r27 = true;
        goto L11
    L25:
        return null;
    }

    public static final List<Widget> b(AIPackageManifestBean r29) {
        Intrinsics.checkNotNullParameter(r29, "<this>");
        List<AIPackageManifestBean.WidgetsBean> r0 = r29.getWidgets();
        if (r0 == null) goto L28;
        ArrayList r10 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L27;
        AIPackageManifestBean.WidgetsBean r11 = (AIPackageManifestBean.WidgetsBean) r1.next();
        String r12 = r11.getName();
        String r13 = r29.getPackageName();
        long r14 = r29.getVersionCode();
        String r15 = r29.getVersionName();
        String r16 = r11.getDescription();
        Icons r17 = r11.getIcons();
        String r18 = r29.getManifestVersion();
        String r19 = r11.getProp();
        String r110 = r11.getRecommend();
        List<String> r111 = r11.getKeywords();
        String r112 = r11.getAppGroup();
        String r113 = r11.getWidgetId();
        String r20 = r11.getEntry();
        String r21 = r11.getInput();
        String r22 = r11.getOutput();
        boolean r23 = r11.getBorder();
        int r24 = r11.getBoxType();
        Integer r25 = Integer.valueOf(r11.getTitleType());
        String r26 = r29.getRuntimeVersion();
        if (r26 != null) goto L10;
        r26 = "";
    L10:
        Widget r114 = new Widget(r12, r13, r14, null, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22, r23, r24, r25, r26, 8);
        r114.i(r11.getDigest());
        if (f.g(r11.getRenderType()) == false) goto L13;
        String r27 = r11.getRenderType();
    L14:
        r114.k(r27);
        Intrinsics.checkNotNullParameter("installed", "<set-?>");
        r114.v = "installed";
        List<AIPackageManifestBean.AppSettingsBean> r28 = r11.getAppSettings();
        ArrayList r30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator<T> r31 = r28.iterator();
    L16:
        if (r31.hasNext() == false) goto L18;
        r30.add(((AIPackageManifestBean.AppSettingsBean) r31.next()).getKey());
        goto L16
    L18:
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        r114.T = r30;
        Integer r32 = r29.getAppType();
        if (r32 == null) goto L21;
        int r33 = r32.intValue();
    L22:
        r114.F = r33;
        Integer r34 = r29.getSourceType();
        if (r34 == null) goto L25;
        int r35 = r34.intValue();
    L26:
        r114.G = r35;
        r10.add(r114);
        goto L6
    L25:
        r35 = 2;
        goto L26
    L21:
        r33 = CastIntegerProtector.parseInt("1");
        goto L22
    L13:
        r27 = r29.getRenderType();
        goto L14
    L27:
        return r10;
    L28:
        return null;
    }
}
