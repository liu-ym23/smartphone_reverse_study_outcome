package com.bytedance.android.livesdk.interactivity.common.combinedtext;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.message.o6;
import com.bytedance.android.live.base.model.message.y5;
import com.bytedance.android.live.base.model.message.z5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.DraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/CombinedTextRenderView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/live/base/model/message/e;", "getComboInfo", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "c", "Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "getOnSchemaHandleListener", "()Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;", "setOnSchemaHandleListener", "(Lcom/bytedance/android/livesdk/interactivity/common/combinedtext/o;)V", "onSchemaHandleListener", "Lkotlin/Function0;", BuildConfig.FLAVOR, "d", "Lkotlin/jvm/functions/Function0;", "getOnImageRenderEndCallback", "()Lkotlin/jvm/functions/Function0;", "setOnImageRenderEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "onImageRenderEndCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", BuildConfig.FLAVOR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CombinedTextRenderView extends LinearLayout {
    public com.bytedance.android.live.base.model.message.d a;
    public final List<Pair<com.bytedance.android.live.base.model.message.f, m>> b;
    public o c;
    public Function0<Unit> d;

    public static final class a {
        public DisplayTextView.a a;
        public DisplayImageListView.a b;

        public a(DisplayTextView.a r2, DisplayImageListView.a r3) {
            Intrinsics.checkNotNullParameter(r2, "textConfig");
            Intrinsics.checkNotNullParameter(r3, "imageConfig");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements n {
        public boolean a;
        public boolean b;
        public final n c;

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void a() {
            if (this.a == true) goto L6;
            this.c.a();
            this.a = true;
            return;
        }

        @Override // com.bytedance.android.livesdk.interactivity.common.combinedtext.n
        public final void b() {
            if (this.b == false) goto L5;
            return;
        L5:
            if (this.a == false) goto L9;
            this.c.b();
            this.b = true;
            return;
        }

        public b(com.bytedance.android.livesdk.interactivity.enteranim.utils.d r2) {
            Intrinsics.checkNotNullParameter(r2, "actual");
            this.c = r2;
        }
    }

    public CombinedTextRenderView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CombinedTextRenderView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final com.bytedance.android.live.base.model.message.e getComboInfo() {
        com.bytedance.android.live.base.model.message.d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final Function0<Unit> getOnImageRenderEndCallback() {
        return this.d;
    }

    public final o getOnSchemaHandleListener() {
        return this.c;
    }

    public final void setOnImageRenderEndCallback(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setOnSchemaHandleListener(o r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [android.view.View, android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.android.livesdk.interactivity.common.combinedtext.DisplayTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v29, types: [android.view.View, com.bytedance.android.livesdk.interactivity.common.combinedtext.ClipImageView] */
    /* JADX WARN: Type inference failed for: r7v53, types: [android.view.View, android.widget.ImageView, com.bytedance.android.livesdk.interactivity.common.combinedtext.ClipImageView] */
    public final void a(com.bytedance.android.live.base.model.message.d r25, a r26) {
        Intrinsics.checkNotNullParameter(r25, "combinedText");
        Intrinsics.checkNotNullParameter(r26, "config");
        this.a = r25;
        ((ArrayList) this.b).clear();
        if (getChildCount() <= 0) goto L5;
        removeAllViews();
    L5:
        List r4 = r25.b();
        if (r4 != null) goto L8;
        return;
    L8:
        Iterator r5 = r4.iterator();
        int r8 = 0;
        com.bytedance.android.live.base.model.message.f r9 = null;
    L10:
        if (r5.hasNext() == false) goto L299;
        Object r10 = r5.next();
        int r13 = r8 + 1;
        if (r8 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        com.bytedance.android.live.base.model.message.f r11 = (com.bytedance.android.live.base.model.message.f) r10;
        com.bytedance.android.live.base.model.message.g r14 = r11.c();
        if (r14 != null) goto L17;
    L19:
        int r15 = -1;
    L21:
        if (r11.j() == false) goto L118;
        if (r15 >= 0) goto L30;
        if (r9 != null) goto L26;
    L28:
        r15 = 0;
        goto L30
    L26:
        if (r9.k() != true) goto L28;
        r15 = s1.f(4.0f);
    L30:
        if (r11.d() == null) goto L34;
        Context r18 = getContext();
        if (r18 == null) goto L34;
        final DisplayImageListView r16 = new DisplayImageListView(r18, null, 0, this.d, 6);
        r16.setOnSchemaHandleListener(this.c);
        DisplayImageListView.a r17 = r26.b;
        Intrinsics.checkNotNullParameter(r11, "displayItem");
        Intrinsics.checkNotNullParameter(r17, "config");
        y5 r6 = r11.d();
        if (r6 != null) goto L39;
    L37:
        List r23 = r4;
        Iterator r19 = r5;
        int r24 = r13;
    L117:
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-2, -2);
        r1.leftMargin = r15;
        addView(r16, r1);
        ((ArrayList) this.b).add(TuplesKt.to(r11, r16));
    L298:
        r9 = r11;
        r5 = r19;
        r8 = r24;
        r4 = r23;
        goto L10
    L39:
        if (r16.getChildCount() <= 0) goto L41;
        r16.removeAllViews();
    L41:
        List r110 = r6.b();
        if (r110 == null) goto L37;
        List r111 = CollectionsKt.filterNotNull(r110);
        if (r111 == null) goto L37;
        DisplayImageListView.b r112 = new DisplayImageListView.b(r111.size(), r16.b);
        List r7 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r20 = r7.iterator();
    L48:
        if (r20.hasNext() == false) goto L58;
        py.k r114 = (py.k) r20.next();
        Iterator r115 = r5;
        List r27 = r4;
        Iterator r21 = r20;
        int r28 = r13;
        DraweeView r2 = new ClipImageView(r16.getContext(), null, 6, 0);
        if (r114.isAnimated() == false) goto L56;
        List r29 = r114.getUrls();
        if (r29 == null) goto L56;
        if ((!r29.isEmpty()) != true) goto L56;
        r2.setController(Fresco.newDraweeControllerBuilder().setUri((String) ListProtector.get(r114.getUrls(), 0)).setAutoPlayAnimations(true).setControllerListener(new f(r2, r114, r112)).build());
    L57:
        r2.setMaxWidth(r17.a);
        r2.setMaxHeight(r17.b);
        r2.setAdjustViewBounds(true);
        r2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        r113.add(r2);
        r5 = r115;
        r20 = r21;
        r13 = r28;
        r4 = r27;
    L56:
        jc1.k.n(IHostFrescoHelper.class).loadFirstAvailableImageBitmap(r114, new g(r2, r112));
        goto L57
    L58:
        r23 = r4;
        r19 = r5;
        r24 = r13;
        if (r6.a() != 1) goto L74;
        if (r113.isEmpty() == true) goto L104;
        int r3 = r17.a - s1.f(2.0f);
        Iterator r30 = r113.iterator();
        int r31 = 0;
    L65:
        if (r30.hasNext() == false) goto L104;
        Object r33 = r30.next();
        int r34 = r31 + 1;
        if (r31 >= 0) goto L69;
        CollectionsKt.throwIndexOverflow();
    L69:
        ?? r35 = (ClipImageView) r33;
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(r17.a, r17.b);
        r116.leftMargin = r31 * r3;
        if (r31 == 0) goto L72;
        r35.setClipOffset(s1.f(4.0f));
    L72:
        r35.setRound(r17.c);
        r35.setRadius(r17.d);
        r35.setBorderDrawable(r17.e);
        r16.addView(r35, r116);
        r31 = r34;
    L104:
        m6 r36 = r11.f();
        if (r36 == null) goto L107;
        final String r37 = r36.a();
    L108:
        if (r37 != null) goto L110;
    L113:
        boolean r117 = true;
    L114:
        if (r117 == true) goto L116;
        r16.setOnClickListener(x0.a(new DisplayImageListView$bind$2(r16, r37)));
        goto L117
    L116:
        r16.setOnClickListener(null);
        r16.setClickable(false);
        goto L117
    L110:
        if (r37.length() == 0) goto L113;
        r117 = false;
        goto L114
    L107:
        r37 = null;
        goto L108
    L74:
        if (r113.isEmpty() == true) goto L86;
        int r38 = r17.a;
        Iterator r39 = r113.iterator();
        int r40 = 0;
    L78:
        if (r39.hasNext() == false) goto L86;
        Object r41 = r39.next();
        int r118 = r40 + 1;
        if (r40 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        ?? r43 = (ClipImageView) r41;
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(-2, -2);
        r119.leftMargin = (-r40) * r38;
        r43.setRound(r17.c);
        r43.setRadius(r17.d);
        r43.setBorderDrawable(r17.e);
        if (r17.f == false) goto L85;
        int r44 = r17.a;
        r119 = new FrameLayout.LayoutParams(r44, r44);
        r43.setScaleType(ImageView.ScaleType.CENTER_CROP);
    L85:
        r16.addView(r43, 0, r119);
        r40 = r118;
    L86:
        z5 r45 = r6.c();
        if (r45 == null) goto L89;
        String r46 = r45.a();
    L91:
        if (r2.a(r46) == false) goto L104;
        Context r47 = r16.getContext();
        z5 r48 = r6.c();
        if (r48 == null) goto L95;
        String r49 = r48.a();
    L96:
        Intrinsics.checkNotNull(r49);
        TextView r50 = new TextView(r47);
        r50.setText(r49);
        r50.setTextColor(-1);
        int r51 = r49.length();
        if (r51 != 1) goto L99;
        float r120 = 9.0f;
    L103:
        r50.setTextSize(1, r120);
        r50.setBackgroundResource(2131250349);
        r50.setGravity(17);
        r50.setIncludeFontPadding(false);
        FrameLayout.LayoutParams r53 = new FrameLayout.LayoutParams(s1.f(13.0f), s1.f(11.0f));
        r53.gravity = 51;
        Unit r54 = Unit.INSTANCE;
        r16.addView(r50, 0, r53);
        goto L104
    L99:
        if (r51 == 2) goto L101;
        r120 = 6.0f;
        goto L103
    L101:
        r120 = 7.0f;
        goto L103
    L95:
        r49 = null;
        goto L96
    L89:
        r46 = null;
    L34:
        r23 = r4;
        r19 = r5;
        r24 = r13;
        goto L298
    L118:
        r23 = r4;
        r19 = r5;
        r24 = r13;
        if (r11.k() == false) goto L298;
        if (r15 >= 0) goto L128;
        if (r9 != null) goto L124;
    L126:
        r15 = 0;
        goto L128
    L124:
        if (r9.j() != true) goto L126;
        r15 = s1.f(4.0f);
    L128:
        if (r11.g() == null) goto L298;
        Context r55 = getContext();
        if (r55 == null) goto L298;
        final ?? r56 = new DisplayTextView(r55, null, 6, 0);
        r56.setOnSchemaHandleListener(this.c);
        DisplayTextView.a r57 = r26.a;
        Intrinsics.checkNotNullParameter(r11, "displayItem");
        Intrinsics.checkNotNullParameter(r57, "config");
        o6 r58 = r11.g();
        if (r58 == null) goto L138;
        a5 r59 = r58.a();
        if (r59 == null) goto L138;
        com.bytedance.android.livesdk.interactivity.common.utils.d.a(r59);
        if (r57.j == false) goto L142;
        r56.setTypeface(null, 1);
    L142:
        float r60 = r57.a;
        o6 r61 = r11.g();
        if (r61 == null) goto L147;
        a5 r63 = r61.a();
        if (r63 == null) goto L147;
        List r64 = r63.getPieces();
    L149:
        if (r11.e() == false) goto L173;
        if (r64 == null) goto L173;
        if (r64.size() != 1) goto L173;
        String r65 = ((c5) ListProtector.get(r64, 0)).getStringValue();
        if (r65 != null) goto L156;
    L159:
        boolean r121 = true;
    L160:
        if (r121 == false) goto L340;
    L166:
        boolean r66 = false;
    L167:
        if (r66 == false) goto L172;
        String r122 = ((c5) ListProtector.get(r64, 0)).getStringValue();
        ((c5) ListProtector.get(r64, 0)).setStringValue(String.valueOf(CastIntegerProtector.parseInt(r122) - 4));
        Float r67 = r57.b;
        if (r67 == null) goto L171;
        r60 = r67.floatValue();
    L171:
        float r68 = r56.getPaint().measureText("A");
        ViewGroup.LayoutParams r123 = new ViewGroup.LayoutParams(-2, -2);
        r56.setMinWidth((int) ((r68 * r122.length()) + 0.5f));
        ViewGroup.LayoutParams r124 = r123;
    L174:
        if (r64 != null) goto L176;
    L204:
        r56.setTextSize(0, r60);
        r56.a = r11;
        String r69 = r57.g;
        if (r69 == null) goto L207;
        yb2.a r70 = w.a();
        r70.d = ColorProtector.parseColor(r69);
        Unit r71 = Unit.INSTANCE;
    L209:
        if (r57.i == false) goto L211;
        r56.setMaxLines(1);
        r56.setEllipsize(TextUtils.TruncateAt.END);
    L211:
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r73 = r.b;
        Intrinsics.checkNotNullParameter(r59, "text");
        tb2.d r74 = r.a(r59, r70);
        if (r70 == null) goto L215;
        r74.b = r70;
    L215:
        if (r57.h == false) goto L281;
        List r75 = r59.getPieces();
        if (r75 == null) goto L233;
        Iterator r76 = r75.iterator();
    L220:
        if (r76.hasNext() == false) goto L227;
        Object r77 = r76.next();
        if (((c5) r77).getType() != PieceType.USER.getPieceType()) goto L224;
        boolean r78 = true;
    L225:
        if (r78 == false) goto L220;
    L228:
        c5 r79 = (c5) r77;
        if (r79 == null) goto L233;
        i5 r80 = r79.getUserValue();
        if (r80 == null) goto L233;
        IBaseUser r81 = r80.getUser();
    L234:
        List<Integer> r83 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.a;
        if (r81 != null) goto L238;
        ArrayList r84 = new ArrayList();
    L260:
        List r85 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.a(r84);
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.h(r85);
        com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.g(r85);
        if ((!((ArrayList) r85).isEmpty()) == false) goto L263;
        List r86 = r85;
    L264:
        if (r86 != null) goto L266;
    L279:
        boolean r87 = false;
    L280:
        r56.c = r87;
        r74.d(r85);
        goto L281
    L266:
        if (r86.isEmpty() == true) goto L279;
        Iterator r88 = r86.iterator();
    L270:
        if (r88.hasNext() == false) goto L279;
        ITextPieceImage r89 = ((tb2.c) r88.next()).getImageValue();
        if (r89 == null) goto L276;
        py.k r90 = r89.getImageModel();
        if (r90 == null) goto L276;
        boolean r91 = r90.isAnimated();
    L277:
        if (r91 == false) goto L270;
        r87 = true;
    L276:
        r91 = false;
        goto L277
    L263:
        r86 = null;
        goto L264
    L238:
        if (r81.getBadgeImageListV2() == null) goto L240;
        Iterable r93 = r81.getBadgeImageListV2();
    L241:
        Intrinsics.checkNotNull(r93);
        ArrayList r94 = new ArrayList();
        Iterator r95 = r93.iterator();
    L243:
        if (r95.hasNext() == false) goto L259;
        Object r96 = r95.next();
        py.k r97 = (py.k) r96;
        Integer r125 = r97.getImageType();
        if (r125 != null) goto L248;
    L249:
        Integer r98 = r97.getImageType();
        if (r98 != null) goto L253;
    L255:
        boolean r99 = false;
    L257:
        if (r99 == false) goto L243;
        r94.add(r96);
        goto L243
    L253:
        if (r98.intValue() != 75) goto L255;
    L256:
        r99 = true;
        goto L257
    L248:
        if (r125.intValue() == 1) goto L256;
    L259:
        r84 = r94;
        goto L260
    L240:
        r93 = new ArrayList();
        goto L241
    L224:
        r78 = false;
        goto L225
    L227:
        r77 = null;
    L233:
        r81 = null;
    L281:
        qb2.c.b(r74, new h(r56), null, 28);
        m6 r100 = r11.f();
        if (r100 == null) goto L284;
        final String r101 = r100.a();
    L285:
        if (r101 != null) goto L287;
    L290:
        boolean r126 = true;
    L291:
        if (r126 == true) goto L293;
        r56.setOnClickListener(x0.a(new DisplayTextView$bind$7(r56, r101)));
    L294:
        if (r124 == null) goto L296;
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r124.width, r124.height);
    L297:
        r102.leftMargin = r15;
        addView(r56, r102);
        ((ArrayList) this.b).add(TuplesKt.to(r11, r56));
        goto L298
    L296:
        r102 = new LinearLayout.LayoutParams(-2, -2);
        goto L297
    L293:
        r56.setOnClickListener(null);
        r56.setClickable(false);
        goto L294
    L287:
        if (r101.length() == 0) goto L290;
        r126 = false;
        goto L291
    L284:
        r101 = null;
        goto L285
    L207:
        r70 = null;
        goto L209
    L176:
        if (r64.size() != 1) goto L204;
        c5 r103 = (c5) ListProtector.get(r64, 0);
        if (r103 != null) goto L342;
    L199:
        boolean r104 = false;
    L200:
        if (r104 == false) goto L204;
        Typeface r105 = r57.k;
        if (r105 == null) goto L204;
        r56.setTypeface(r105);
        goto L204
    L342:
        String r106 = r103.getStringValue();     // Catch: Exception -> L198
        if (r106 != null) goto L183;
    L186:
        boolean r107 = true;
    L187:
        if (r107 == true) goto L199;
        if (StringsKt.toIntOrNull(r106) == null) goto L193;
    L197:
        r104 = true;
        goto L200
    L193:
        if (StringsKt.endsWith$default(r106, "+", false, 2, null) == false) goto L199;
        Integer r108 = StringsKt.toIntOrNull(r106.substring(0, r106.length() - 1));     // Catch: Exception -> L198
        if (r108 == null) goto L199;
        r108.intValue();     // Catch: Exception -> L198
        goto L197
    L183:
        if (r106.length() == 0) goto L186;
        r107 = false;
        goto L187
    L172:
        r11.m();
        goto L173
    L340:
        if (CastIntegerProtector.parseInt(r65) < 10) goto L166;
        r66 = true;
        goto L167
    L156:
        if (r65.length() == 0) goto L159;
        r121 = false;
    L173:
        r124 = null;
    L147:
        r64 = null;
    L138:
        r124 = null;
        goto L294
    L17:
        if (r14.enableLeftSpace == false) goto L19;
        r15 = (int) r14.leftSpace;
        goto L21
    L299:
        List r210 = r4;
        m6 r109 = r25.c();
        if (r109 == null) goto L302;
        final String r127 = r109.a();
    L303:
        if (r127 != null) goto L305;
    L308:
        boolean r128 = true;
    L309:
        if (r128 == true) goto L311;
        setOnClickListener(x0.a(new CombinedTextRenderView$bind$2(this, r127)));
    L312:
        DisplayTextView.a r129 = r26.a;
        Integer r130 = r129.c;
        Integer r131 = r129.d;
        if (r131 == null) goto L315;
        int r132 = r131.intValue();
    L316:
        Integer r133 = r26.a.e;
        if (r133 == null) goto L319;
        int r134 = r133.intValue();
    L320:
        Integer r135 = r26.a.f;
        if (r135 == null) goto L323;
        int r136 = r135.intValue();
    L324:
        if (r130 == null) goto L326;
        int r137 = r130.intValue();
    L338:
        setPadding(r137, r134, r132, r136);
        return;
    L326:
        com.bytedance.android.live.base.model.message.f r138 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.firstOrNull(r210);
        if (r138 == null) goto L331;
        boolean r139 = true;
        if (r138.k() != true) goto L332;
        r137 = s1.f(8.0f);
    L332:
        com.bytedance.android.live.base.model.message.f r140 = (com.bytedance.android.live.base.model.message.f) CollectionsKt.firstOrNull(r210);
        if (r140 != null) goto L335;
    L337:
        r137 = 0;
        goto L338
    L335:
        if (r140.h() != r139) goto L337;
        r137 = s1.f(6.0f);
        goto L338
    L331:
        r139 = true;
        goto L332
    L323:
        r136 = 0;
        goto L324
    L319:
        r134 = 0;
        goto L320
    L315:
        r132 = 0;
        goto L316
    L311:
        setOnClickListener(null);
        setClickable(false);
        goto L312
    L305:
        if (r127.length() == 0) goto L308;
        r128 = false;
        goto L309
    L302:
        r127 = null;
        goto L303
    }

    public CombinedTextRenderView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new ArrayList();
        this.d = CombinedTextRenderView$onImageRenderEndCallback$1.INSTANCE;
        setOrientation(0);
        setGravity(17);
    }

    public /* synthetic */ CombinedTextRenderView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
