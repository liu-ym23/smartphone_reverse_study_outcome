package com.ss.android.lark.chat.chatwindow.chat.model.viewdata;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.im.api.message.params.l;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.chat.utils.c1;
import com.ss.android.lark.chat.utils.s;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.RenderRouterEntity;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.WidthMode;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import com.ss.android.lark.export.params.URLPreviewParams;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import g3b.v;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements com.ss.android.lark.chat.core.model.b.a<y6b.c<?>> {
    public final Context a;
    public final Chat b;
    public final m2b.a c;
    public final Map<Class<? extends l>, l> d;
    public final LifecycleOwner e;
    public boolean f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Message.Type.values().length];
            r0[Message.Type.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void a(List<y6b.c<?>> r1, int r2, int r3) {
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void c(List r2, int r3) {
        e(r2, r3, 1);
    }

    @Override // com.ss.android.lark.chat.core.model.b.a
    public final void b(List<y6b.c<?>> r1, int r2, int r3) {
        e(r1, r2, r3);
    }

    public final void d(Map<String, PreviewHangPoint> r23, y6b.c<?> r24, Map<String, xcb.b> r25) {
        List r2 = CollectionsKt.toMutableList(r23.values());
        boolean r4 = true;
        int r3 = Math.min(3, r2.size() - 1);
        if (r3 < 0) goto L166;
        int r6 = 0;
    L5:
        PreviewHangPoint r7 = (PreviewHangPoint) ListProtector.get(r2, r6);
        if (r7.isSmartCard() == true) goto L164;
        if (r7.isValidCardData() == false) goto L164;
        UrlCardPreviewEntity r8 = r7.getUrlCardPreviewEntity();
        if (r8 == null) goto L164;
        boolean r9 = StringsKt.startsWith(r8.getInlineEntity().getPreviewId(), "urlPreview", r4);
        long r10 = System.currentTimeMillis();
        Map<String, ? extends Object> r12 = MapsKt.toMutableMap(ChatParamUtils.i(r24));
        r12.putAll(ChatHitPointNew.a(r24));
        m2b.a r13 = this.c;
        if (r13 == null) goto L17;
        lya.a r14 = r13.l();
        if (r14 == null) goto L17;
        Integer r15 = r14.a();
    L18:
        m2b.a r16 = this.c;
        if (r16 == null) goto L61;
        int r17 = g.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r24, "messageVo");
        lya.a r5 = r16.l();
        if (r5 == null) goto L23;
        Integer r11 = r5.a();
    L25:
        if (g.a.a[r24.getType().ordinal()] == r4) goto L27;
        FragmentActivity r18 = r16.getContext();
        if (c1.a(r24, r16, null) == true) goto L49;
    L51:
        boolean r19 = q7b.c.a(r24, r16);
        if (r16.m() == false) goto L54;
    L59:
        boolean r21 = false;
    L60:
        int r20 = r16.H8().b(r18, r11, g.a(r24), r24.V1, r21);
    L62:
        if (r20 == 0) goto L64;
    L89:
        int r22 = edb.c.a;
        Context r26 = this.a;
        RenderRouterEntity r110 = r8.getRenderRouterEntity();
        if (r110 == null) goto L92;
        WidthMode r111 = r110.getWidthMode();
    L93:
        int r27 = RangesKt.coerceAtMost(r20, edb.c.b(r26, r111));
        UrlInlinePreviewEntity r28 = r8.getInlineEntity();
        URLPreviewParams.a r112 = new URLPreviewParams.a();
        if (r28 == null) goto L96;
        String r113 = r28.getPreviewId();
    L97:
        r112.a = r113;
        r112.b = r9;
        if (r28 == null) goto L102;
        Url r29 = r28.getUrl();
        if (r29 == null) goto L102;
        String r30 = r29.getUrl();
    L103:
        r112.c = r30;
        Chat r31 = this.b;
        if (r31 == null) goto L109;
        if (r31.isGroup() != true) goto L109;
        boolean r32 = true;
    L110:
        r112.d = r32;
        Intrinsics.checkNotNullParameter(r12, "messageParams");
        r112.e = r12;
        Chat r33 = this.b;
        String r114 = BuildConfig.FLAVOR;
        if (r33 == null) goto L114;
        String r34 = r33.getId();
        if (r34 == null) goto L114;
    L115:
        r112.f = r34;
        Chat r35 = this.b;
        if (r35 == null) goto L119;
        String r36 = r35.getName();
        if (r36 == null) goto L119;
    L120:
        r112.g = r36;
        if (r28 == null) goto L123;
        String r37 = r28.getSourceId();
    L124:
        r112.h = r37;
        if (r28 == null) goto L129;
        UrlInlinePreviewEntity.AppInfo r38 = r28.getAppInfo();
        if (r38 == null) goto L129;
        Long r39 = r38.getAppId();
    L130:
        r112.i = r39;
        if (r28 == null) goto L135;
        UrlInlinePreviewEntity.AppInfo r40 = r28.getAppInfo();
        if (r40 == null) goto L135;
        Long r41 = r40.getSceneType();
    L136:
        r112.j = r41;
        if (r28 == null) goto L139;
        r28.getTitle();
    L139:
        Map<String, MessageLink> r42 = r24.p2;
        if (r42 == null) goto L145;
        if (r28 == null) goto L143;
        String r43 = r28.getPreviewId();
    L144:
        MessageLink r44 = r42.get(r43);
        goto L145
    L143:
        r43 = null;
    L145:
        r112.k = Boolean.valueOf(r24.N);
        MessageEditInfo r45 = r24.C;
        if (r45 == null) goto L148;
        boolean r46 = r45.isEdited();
    L149:
        r112.l = r46;
        vcb.d r47 = new vcb.d(this.a, this.e, new URLPreviewParams(r112));
        t6c.d r115 = null;
        com.ss.android.lark.chat.preview.creator.a r48 = new com.ss.android.lark.chat.preview.creator.a(r47, null);
        UrlPreviewBody r49 = r8.getPreviewBody();
        if (r49 == null) goto L152;
        String r50 = r49.getCurrentStateId();
    L153:
        q6c.b r51 = r48.c(r8, r50);
        if (r51 == null) goto L156;
        r115 = new t6c.d(r51, new f(), UIHelper.px2dp(r27));
    L156:
        if (r115 == null) goto L164;
        String r52 = r7.getPreviewId();
        if (r52 == null) goto L162;
        r114 = r52;
    L162:
        r25.put(r114, new xcb.b(r8, r115));
        r8.setComponentTreeTime(System.currentTimeMillis() - r10);
        goto L164
    L152:
        r50 = null;
        goto L153
    L148:
        r46 = false;
    L135:
        r41 = null;
    L129:
        r39 = null;
        goto L130
    L123:
        r37 = null;
    L119:
        r36 = BuildConfig.FLAVOR;
    L114:
        r34 = BuildConfig.FLAVOR;
    L109:
        r32 = false;
    L102:
        r30 = null;
        goto L103
    L96:
        r113 = null;
        goto L97
    L92:
        r111 = null;
        goto L93
    L64:
        if (b.a[r24.getType().ordinal()] != 1) goto L66;
        int r53 = j.a;
        r20 = j.c(this.a, r15, s.c(r24));
        goto L89
    L66:
        int r54 = c1.a;
        m2b.a r55 = this.c;
        Map<Class<? extends l>, l> r56 = this.d;
        if (r56 == null) goto L69;
        l r57 = r56.get(v.class);
    L71:
        if ((r57 instanceof v) == false) goto L73;
        v r58 = (v) r57;
    L75:
        if (c1.a(r24, r55, r58) == true) goto L77;
    L83:
        m2b.a r59 = this.c;
        if (r59 == null) goto L88;
        o3b.a r116 = r59.H8();
        if (r116 == null) goto L88;
        r20 = r116.b(this.a, r15, false, false, false);
    L88:
        r20 = 0;
        goto L89
    L77:
        if (r24.d() == true) goto L83;
        m2b.a r60 = this.c;
        if (r60 == null) goto L88;
        o3b.a r61 = r60.H8();
        if (r61 == null) goto L88;
        r20 = o3b.a.C0267a.a(r61, this.a, r15);
        goto L89
    L73:
        r58 = null;
        goto L75
    L69:
        r57 = null;
        goto L71
    L54:
        if (r16.Y() == true) goto L56;
    L58:
        r21 = r19;
        goto L60
    L56:
        if (g.a(r24) == false) goto L58;
    L49:
        if (r24.d() == true) goto L51;
        r20 = r16.H8().d(r16.getContext(), r11, g.a(r24), r24.V1, q7b.c.a(r24, r16));
        goto L62
    L27:
        if (r16.m() == false) goto L32;
        int r117 = j.a;
        FragmentActivity r118 = r16.getContext();
        Intrinsics.checkNotNullParameter(r118, "context");
        int r62 = j.n(r118, r11) - (j.f * 2);
        int r63 = j.m;
    L29:
        int r64 = r63 * 2;
    L30:
        r20 = r62 - r64;
        goto L62
    L32:
        if (r16.r() == false) goto L37;
        if (r16.q() == true) goto L37;
        FragmentActivity r119 = r16.getContext();
        int r120 = j.a;
        Intrinsics.checkNotNullParameter(r119, "context");
        r62 = j.n(r119, r11) - (j.g * 2);
        r63 = j.m;
    L37:
        if (r16.q() == false) goto L40;
        int r121 = j.a;
        FragmentActivity r122 = r16.getContext();
        Intrinsics.checkNotNullParameter(r122, "context");
        r62 = (j.n(r122, r11) - (j.g * 2)) - (j.m * 2);
        r64 = j.n;
        goto L30
    L40:
        if (r16.Y() == true) goto L42;
        int r65 = j.a;
        r20 = j.c(r16.getContext(), r11, s.c(r24));
        goto L62
    L42:
        if (r24.Y() == false) goto L44;
        int r66 = j.a;
        r20 = j.h(r16.getContext(), r24.V1, r11);
        goto L62
    L44:
        int r67 = j.a;
        r20 = j.g(r16.getContext(), r24.V1, r11);
        goto L62
    L23:
        r11 = null;
        goto L25
    L61:
        r20 = 0;
    L17:
        r15 = null;
    L164:
        if (r6 == r3) goto L168;
        r6 = r6 + 1;
        r4 = true;
        goto L5
    L168:
        return;
    }

    public final void e(List<y6b.c<?>> r4, int r5, int r6) {
        if (this.f == true) goto L5;
        return;
    L5:
        if (r4 == null) goto L30;
        int r7 = r6 + r5;
    L7:
        if (r5 >= r7) goto L38;
        y6b.c<?> r0 = (y6b.c) ListProtector.get(r4, r5);
        if (r0.getType() != Message.Type.TEXT) goto L16;
        T r1 = r0.o;
        if ((r1 instanceof com.ss.android.lark.chat.base.view.vo.message.e) == false) goto L16;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.TextContentVO");
        if ((!((com.ss.android.lark.chat.base.view.vo.message.e) r1).C.isEmpty()) == false) goto L16;
        T r2 = r0.o;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.TextContentVO");
        com.ss.android.lark.chat.base.view.vo.message.e r3 = (com.ss.android.lark.chat.base.view.vo.message.e) r2;
        d(r3.C, r0, r3.B);
    L29:
        r5 = r5 + 1;
    L16:
        if (r0.getType() != Message.Type.POST) goto L23;
        T r8 = r0.o;
        if ((r8 instanceof PostContentVO) == false) goto L23;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO");
        if ((!((PostContentVO) r8).C.isEmpty()) == false) goto L23;
        T r9 = r0.o;
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.PostContentVO");
        PostContentVO r10 = (PostContentVO) r9;
        d(r10.C, r0, r10.B);
    L23:
        if (r0.getType() != Message.Type.FILE) goto L29;
        T r11 = r0.o;
        if ((r11 instanceof FileContentVO) == false) goto L29;
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.FileContentVO");
        if ((!((FileContentVO) r11).j().isEmpty()) == false) goto L29;
        T r12 = r0.o;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.FileContentVO");
        FileContentVO r13 = (FileContentVO) r12;
        d(r13.j(), r0, r13.B);
        goto L29
    L38:
        return;
    }

    public e(Context r2, Chat r3, m2b.a r4, Map<Class<? extends l>, ? extends l> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        LifecycleOwner r6 = null;
        if (r4 != null) goto L30;
    L10:
        LifecycleOwner r7 = null;
    L11:
        if (r7 != null) goto L27;
        m2b.a r8 = this.c;
        if (r8 == null) goto L15;
        r7 = r8.R();
    L16:
        if (r7 != null) goto L27;
        m2b.a r9 = this.c;
        if (r9 == null) goto L21;
        r7 = r9.getContext();
    L22:
        if (r7 != null) goto L27;
        LifecycleOwner r10 = ContextsKt.requireActivity(this.a);
        if ((r10 instanceof LifecycleOwner) == false) goto L28;
        r6 = r10;
    L28:
        this.e = r6;
        return;
    L21:
        r7 = null;
        goto L22
    L15:
        r7 = null;
    L27:
        r6 = r7;
        goto L28
    L30:
        Fragment r11 = r4.R();     // Catch: Exception -> L8
        if (r11 == null) goto L10;
        r7 = r11.getViewLifecycleOwner();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e("URLAsyncMeasureInterceptor", e.getMessage());
        goto L10
    }
}
