package com.ss.android.lark.coremdbiz.facade.plugins.markdown;

import android.content.res.Resources;
import android.os.Looper;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderAtProperty;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInline;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderUrlPreviewInlines;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.coremd.base.parse.m;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownAtUser;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownUrlPreviewInline;
import com.ss.android.lark.coremdbiz.facade.p;
import com.ss.ttvideoengine.utils.ScreenUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e<T extends s> implements q {
    public final /* synthetic */ MarkdownPlugin a;

    public e(MarkdownPlugin r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final i r40) {
        Intrinsics.checkNotNullParameter(r40, "it");
        LarkContextExtend.a r2 = LarkContextExtend.s;
        int r3 = ((Number) r2.b(new MarkdownPlugin$configureSpanFactory$1$maxWidth$1(r40))).intValue();
        final Function3 r6 = (Function3) r2.b(new MarkdownPlugin$configureSpanFactory$1$imageClickHandler$1(r40));
        final boolean r10 = ((Boolean) r2.b(new MarkdownPlugin$configureSpanFactory$1$enableSelection$1(r40))).booleanValue();
        boolean r4 = ((Boolean) r2.b(new MarkdownPlugin$configureSpanFactory$1$documentPreloadOnly$1(r40))).booleanValue();
        boolean r5 = ((Boolean) r2.b(new MarkdownPlugin$configureSpanFactory$1$isFromTopicGroup$1(r40))).booleanValue();
        final Function1 r8 = (Function1) r2.b(new MarkdownPlugin$configureSpanFactory$1$longPressHandler$1(r40));
        final Function0 r11 = (Function0) r2.b(new MarkdownPlugin$configureSpanFactory$1$autoScrollStrategyProvider$1(r40));
        Function0 r13 = (Function0) r2.b(new MarkdownPlugin$configureSpanFactory$1$selectionDragStartHandler$1(r40));
        Function0 r14 = (Function0) r2.b(new MarkdownPlugin$configureSpanFactory$1$selectionClearHandler$1(r40));
        final com.ss.android.lark.movable.selection.h r12 = (com.ss.android.lark.movable.selection.h) r2.b(new MarkdownPlugin$configureSpanFactory$1$copyHandler$1(r40));
        MarkdownPlugin r7 = this.a;
        List r9 = (List) r2.b(new MarkdownPlugin$configureSpanFactory$1$urlPreviewInlines$1(r40));
        r7.getClass();
        ArrayList r15 = new ArrayList();
        Iterator r16 = r9.iterator();
    L3:
        boolean r17 = true;
        if (r16.hasNext() == false) goto L43;
        MarkdownUrlPreviewInline r18 = (MarkdownUrlPreviewInline) r16.next();
        String r21 = StringsKt.trim(r18.getOriginUrl()).toString();
        String r23 = StringsKt.trim(r18.getTitle()).toString();
        if (r21.length() != 0) goto L8;
        boolean r19 = true;
    L9:
        if (r19 == false) goto L11;
    L39:
        MovableRenderUrlPreviewInline r110 = null;
    L40:
        if (r110 == null) goto L3;
        r15.add(r110);
        goto L3
    L11:
        if (r23.length() != 0) goto L13;
        boolean r111 = true;
    L14:
        if (r111 == true) goto L39;
        String r20 = r18.getPreviewId();
        String r22 = StringsKt.trim(r18.getClickUrl()).toString();
        String r112 = r18.getIconKey();
        if (r112 == null) goto L26;
        String r113 = StringsKt.trim(r112).toString();
        if (r113 == null) goto L26;
        if (r113.length() <= 0) goto L23;
        boolean r114 = true;
    L24:
        if (r114 == false) goto L26;
        String r24 = r113;
    L27:
        String r25 = r18.getIconType();
        if (r25 == null) goto L37;
        String r26 = StringsKt.trim(r25).toString();
        if (r26 == null) goto L37;
        if (r26.length() > 0) goto L35;
        r17 = false;
    L35:
        if (r17 == false) goto L37;
        String r27 = r26;
    L38:
        r110 = new MovableRenderUrlPreviewInline(r20, r21, r22, r23, r24, r27);
    L37:
        r27 = null;
        goto L38
    L23:
        r114 = false;
    L26:
        r24 = null;
        goto L27
    L13:
        r111 = false;
        goto L14
    L8:
        r19 = false;
        goto L9
    L43:
        if ((!r15.isEmpty()) == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L48;
        MovableRenderUrlPreviewInlines r28 = new MovableRenderUrlPreviewInlines(r15);
    L49:
        MovableRenderConfig r115 = (MovableRenderConfig) LarkContextExtend.s.b(new MarkdownPlugin$configureSpanFactory$1$renderConfig$1(r40));
        final MarkdownPlugin r29 = this.a;
        final eab.e r30 = (eab.e) r40.d;
        m r0 = r40.d();
        r29.getClass();
        if (r115 == null) goto L80;
        Map<String, MarkdownAtUser> r116 = r30.n;
        if (r116 == null) goto L73;
        LinkedHashMap r1 = new LinkedHashMap(MapsKt.mapCapacity(r116.size()));
        Iterator r31 = r116.entrySet().iterator();
    L55:
        if (r31.hasNext() == false) goto L72;
        Map.Entry r117 = (Map.Entry) r31.next();
        Iterator r210 = r31;
        Object r32 = r117.getKey();
        MarkdownAtUser r118 = (MarkdownAtUser) r117.getValue();
        String r211 = r118.getUserId();
        if (r211 != null) goto L59;
        String r33 = BuildConfig.FLAVOR;
    L60:
        String r212 = r118.getContent();
        Function0 r38 = r13;
        Function0 r37 = r14;
        if (r212 != null) goto L63;
        String r119 = BuildConfig.FLAVOR;
    L65:
        if ((!Intrinsics.areEqual(r119, "@")) == true) goto L68;
        r119 = null;
    L68:
        if (r119 != null) goto L70;
        String r34 = BuildConfig.FLAVOR;
    L71:
        r1.put(r32, new MovableRenderAtProperty(r33, r34, Boolean.valueOf(r118.isOutChatUser()), Boolean.valueOf(r118.isAnonymous()), Boolean.valueOf(r118.isHighLight())));
        r31 = r210;
        r14 = r37;
        r13 = r38;
        goto L55
    L70:
        r34 = r119;
        goto L71
    L63:
        r119 = r212;
        goto L65
    L59:
        r33 = r211;
        goto L60
    L72:
        Function0 r39 = r13;
        Function0 r310 = r14;
    L74:
        if (r1 != null) goto L76;
        Map r213 = MapsKt.emptyMap();
    L77:
        MovableRenderConfig r35 = MovableRenderConfig.copy$default(r115, null, null, null, null, null, null, null, null, r213, ScreenUtils.MAX_SYSTEM_BRIGHTNESS, null);
        if (r35 == null) goto L81;
    L82:
        final boolean r120 = p.a();
        if (r3 <= 0) goto L87;
        if (r120 == false) goto L86;
        if (r3 == Integer.MAX_VALUE) goto L87;
    L86:
        boolean r214 = true;
    L88:
        if (r120 == false) goto L91;
        if (r214 == true) goto L91;
        float r121 = 0.0f;
    L92:
        final h r122 = new h(r121, r30, MarkdownPlugin.e(r28), r35);
        if (r120 == false) goto L95;
        if (r214 == false) goto L139;
        if (r4 == false) goto L139;
        MarkdownPlugin.Companion r36 = MarkdownPlugin.b;
        if (MarkdownPlugin.Companion.b(r122) != null) goto L139;
        final a r41 = new a(r122.a, r122.b, r35);
        if (r28 == null) goto L109;
        List r42 = r28.getItems();
        if (r42 == null) goto L109;
        int r43 = r42.size();
    L111:
        if (10 <= r43) goto L113;
    L115:
        boolean r215 = false;
    L116:
        if (r215 == false) goto L120;
        long r44 = 2000;
    L118:
        long r123 = r44;
        HashMap<a, Job> r45 = MarkdownPlugin.f;
        monitor-enter(r45);
        Job r46 = r45.remove(r41);     // Catch: Throwable -> L136
        if (r46 == null) goto L133;
        Job.DefaultImpls.cancel$default(r46, null, 1, null);     // Catch: Throwable -> L136
    L133:
        final Job r47 = BuildersKt.launch$default(MarkdownPlugin.e, null, null, new MarkdownPlugin$Companion$scheduleDocumentPreload$1$job$1(r123, r122, r35, r28, null), 3, null);     // Catch: Throwable -> L136
        r45.put(r41, r47);     // Catch: Throwable -> L136
        r47.invokeOnCompletion(new MarkdownPlugin$Companion$scheduleDocumentPreload$1$1(r41, r47));     // Catch: Throwable -> L136
        monitor-exit(r45);
    L140:
        final MovableRenderConfig r48 = r35;
        final Function0 r124 = r39;
        final Function0 r125 = r310;
        final MovableRenderUrlPreviewInlines r126 = r28;
        final boolean r127 = r214;
        final int r128 = r3;
        final m r216 = r0;
        return new MarkdownPlugin$prepareMarkdownSpan$2(r29, r6, r30, r8, r48, r10, r11, r12, r124, r125, r120, r126, r127, r128, r122, r216);
    L136:
        th = move-exception;
        throw th;
    L120:
        if (4 > r43) goto L123;
        if (r43 >= 10) goto L123;
        boolean r129 = true;
    L124:
        if (r129 == false) goto L126;
        r44 = 500;
        goto L118
    L126:
        r44 = 200;
    L123:
        r129 = false;
        goto L124
    L113:
        if (r43 > Integer.MAX_VALUE) goto L115;
        r215 = true;
    L109:
        r43 = 0;
    L139:
        r3 = r3;
        goto L140
    L95:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L139;
        if (r5 == true) goto L139;
        MarkdownPlugin.Companion r49 = MarkdownPlugin.b;
        if (MarkdownPlugin.Companion.b(r122) != null) goto L139;
        BuildersKt.runBlocking$default(null, new MarkdownPlugin$prepareMarkdownSpan$1(r122, r35, r28, null), 1, null);
    L91:
        Resources r130 = Resources.getSystem();
        r121 = (int) ((r3 / WindowDisplayMetricsOverride.apply(r130, r130.getDisplayMetrics()).density) + 0.5f);
    L87:
        r214 = false;
    L81:
        r35 = com.ss.android.lark.movable.utils.a.c();
        goto L82
    L76:
        r213 = r1;
        goto L77
    L73:
        r39 = r13;
        r310 = r14;
        r1 = null;
        goto L74
    L80:
        r0 = r0;
        r39 = r13;
        r310 = r14;
        goto L81
    L48:
        r28 = null;
        goto L49
    }
}
