package com.obric.memorydata.markdown.custom;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ba;
import com.obric.memorydata.utils.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\rJ4\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\rJ,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\rH\u0002J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/markdown/custom/MapLauncher;", "", "<init>", "()V", "showPicker", "", "context", "Landroid/content/Context;", "addresses", "", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "callback", "Lkotlin/Function1;", "showSingle", MemoryKeyInfoEntity.KEY_ADDRESS, "showMapApps", "open", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f9983a = null;

    static {
        f9983a = new e();
    }

    private e() {
    }

    private static final Unit a(final String r8, final boolean r9, Context r10, final boolean r11, Function1 r12, f r13) {
        final Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        final Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "$this$showMenu");
        r13.a(r8);
        if (r9 == false) goto L5;
        String r0 = r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_gaode_map, TypedValues.Custom.S_STRING, "markdown_action_gaode_map"));
    L6:
        Intrinsics.checkNotNull(r0);
        r13.a(r0, new $$Lambda$e$TjAZxJRVuFdEPSdiqGDXDXzmO_8(r9, r14, r8, r15));
        if (r11 == false) goto L9;
        String r16 = r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_baidu_map, TypedValues.Custom.S_STRING, "markdown_action_baidu_map"));
    L10:
        Intrinsics.checkNotNull(r16);
        r13.a(r16, new $$Lambda$e$2LY9cHdUA0h6K97VFkpdscFGfFQ(r11, r14, r8, r15));
        return Unit.INSTANCE;
    L9:
        r16 = r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_app_not_installed_format, TypedValues.Custom.S_STRING, "markdown_action_app_not_installed_format"), new Object[]{r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_baidu_map, TypedValues.Custom.S_STRING, "markdown_action_baidu_map"))});
        goto L10
    L5:
        r0 = r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_app_not_installed_format, TypedValues.Custom.S_STRING, "markdown_action_app_not_installed_format"), new Object[]{r14.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_gaode_map, TypedValues.Custom.S_STRING, "markdown_action_gaode_map"))});
        goto L6
    }

    private static final Unit a(boolean r2, Context r3, String r4, Function1 r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L5;
        com.obric.memorydata.utils.d.f13204a.b(r6, "com.autonavi.minimap");
    L9:
        return Unit.INSTANCE;
    L5:
        if (a.a(r6, z.f13269a.b(r4, "com.autonavi.minimap")) == false) goto L9;
        r7.invoke("com.autonavi.minimap");
        goto L9
    }

    private static final void a(Context r1, String r2, View r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        a.a(r4, MemoryKeyInfoEntity.KEY_ADDRESS, r2);
        String r5 = r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copied, TypedValues.Custom.S_STRING, "markdown_action_copied"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        ba.a(r4, r5, 80);
    }

    private final void a(Context r8, final String r9, Function1<? super String, Unit> r10) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        final Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        final boolean r3 = com.obric.memorydata.utils.d.f13204a.a(r7, "com.autonavi.minimap");
        final boolean r5 = com.obric.memorydata.utils.d.f13204a.a(r7, "com.baidu.BaiduMap");
        RunLog.INSTANCE.debug("CustomActions", "address: " + r9 + ", gaodeOk: " + r3 + ", baiduOk: " + r5);
        g.a(r7, new $$Lambda$e$oLMqheBPg_xZl9NAM2DiW6AlVxo(r9, r3, r7, r5, r6));
    }

    private static final void a(Context r1, String r2, Function1 r3, View r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        f9983a.a(r5, r2, r6);
    }

    private static final Unit b(boolean r2, Context r3, String r4, Function1 r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L5;
        com.obric.memorydata.utils.d.f13204a.b(r6, "com.baidu.BaiduMap");
    L9:
        return Unit.INSTANCE;
    L5:
        if (a.a(r6, z.f13269a.b(r4, "com.baidu.BaiduMap")) == false) goto L9;
        r7.invoke("com.baidu.BaiduMap");
        goto L9
    }

    private static final void b(Context r1, String r2, Function1 r3, View r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        Function1<? super String, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        f9983a.a(r5, r2, r6);
    }

    public static /* synthetic */ Unit lambda$2LY9cHdUA0h6K97VFkpdscFGfFQ(boolean r0, Context r1, String r2, Function1 r3) {
        return b(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$LukMIyFqej-RXtp6Qx7e85o1gHM, reason: not valid java name */
    public static /* synthetic */ void m678lambda$LukMIyFqejRXtp6Qx7e85o1gHM(Context r0, String r1, Function1 r2, View r3) {
        b(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$TjAZxJRVuFdEPSdiqGDXDXzmO_8(boolean r0, Context r1, String r2, Function1 r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$_UGqjutqstystl7SUoDc2UghnCc(Context r0, String r1, Function1 r2, View r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$hwviT_HUISkqtkkxWAoLxJoPZvo(Context r0, String r1, View r2) {
        a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$oLMqheBPg_xZl9NAM2DiW6AlVxo(String r0, boolean r1, Context r2, boolean r3, Function1 r4, f r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public final void a(Context r5, String r6, String r7, Function1<? super String, Unit> r8) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        final Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, MemoryKeyInfoEntity.KEY_ADDRESS);
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r9, "callback");
        final String r10 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        List<String> r11 = CollectionsKt.listOf(new String[]{r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_view_route, TypedValues.Custom.S_STRING, "markdown_action_view_route")), r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_copy, TypedValues.Custom.S_STRING, "markdown_action_copy"))});
        List<? extends View.OnClickListener> r12 = CollectionsKt.listOf(new View.OnClickListener[]{new $$Lambda$e$LukMIyFqejRXtp6Qx7e85o1gHM(r4, r10, r9), new $$Lambda$e$hwviT_HUISkqtkkxWAoLxJoPZvo(r4, r10)});
        h r13 = new h(r4);
        r13.a(r10);
        r13.a(r11, r12);
        r13.a();
    }

    public final void a(Context r5, List<String> r6, String r7, Function1<? super String, Unit> r8) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        final Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r9, "addresses");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L4
    L6:
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L12;
        Object r1 = r16.next();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L8;
        r15.add(r1);
        goto L8
    L12:
        List r17 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r17.isEmpty() == false) goto L15;
        return;
    L15:
        List<String> r18 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r19.iterator();
    L17:
        if (r21.hasNext() == false) goto L19;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.memorydata.plugin");
        r20.add(new $$Lambda$e$_UGqjutqstystl7SUoDc2UghnCc(r4, r2, r10));
        goto L17
    L19:
        List<? extends View.OnClickListener> r22 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        h r23 = new h(r4);
        String r24 = r4.getString(ZeusTransformUtils.mapRes(R.string.markdown_action_view_route, TypedValues.Custom.S_STRING, "markdown_action_view_route"));
        Intrinsics.checkNotNullExpressionValue(r24, "getString(...)");
        r23.a(r24);
        r23.a(r18, r22);
        r23.a();
    }
}
