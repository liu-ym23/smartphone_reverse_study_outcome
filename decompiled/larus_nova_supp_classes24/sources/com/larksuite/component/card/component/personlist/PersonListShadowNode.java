package com.larksuite.component.card.component.personlist;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y6a.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J(\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J6\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u001eH\u0002J\u000e\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larksuite/component/card/component/personlist/PersonListShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "mText", "", "mProp", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "setContext", "", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "setContent", "props", "Lcom/lynx/react/bridge/ReadableMap;", "onLayout", "left", "", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "getExtraBundle", "", "getAndroidMode", "measureWidthMode", "setClickPersonListener", "clickPersonListener", "Lcom/larksuite/component/card/component/personlist/IClickPersonListener;", "setClickMoreListener", "clickMoreListener", "Lcom/larksuite/component/card/component/personlist/PersonListLynxUI$ClickMoreListener;", "mClickPersonListener", "mClickMoreListener", "Lcom/larksuite/component/card/component/personlist/IClickMoreListener;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class PersonListShadowNode extends ShadowNode implements y6a.h {
    public AppCompatTextView v;
    public CharSequence w;
    public PersonListProps x;
    public com.larksuite.component.card.component.personlist.b y;
    public PersonListLynxUI.a z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MeasureMode.values().length];
            r0[MeasureMode.EXACTLY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MeasureMode.UNDEFINED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MeasureMode.AT_MOST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public PersonListShadowNode() {
        i(this);
    }

    public final Object m() {
        return this.w;
    }

    public static int C(MeasureMode r1) {
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return 1073741824;
    L5:
        if (r2 != 2) goto L7;
        return 0;
    L7:
        if (r2 != 3) goto L10;
        return LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    @LynxProp(name = "props")
    public final void setContent(ReadableMap r4) {
        Intrinsics.checkNotNullParameter(r4, "props");
        ICardDependency r1 = null;
        this.w = null;
        Gson r2 = com.larksuite.component.card.component.g.a;     // Catch: Throwable -> L5
        PersonListProps r5 = (PersonListProps) com.larksuite.component.card.component.g.c(r4, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r5 != null) goto L10;
        Log.e("PersonListShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.x = r5;
        AppCompatTextView r6 = this.v;
        if (r6 == null) goto L16;
        TextPaint r7 = r6.getPaint();
        g r0 = g.a;
        PersonListProps r3 = this.x;
        r0.getClass();
        r7.setTextSize(g.h(r3));
        int r8 = g.g(this.x);
        TextView r9 = this.v;
        if (r9 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r9 = null;
    L15:
        r9.getPaint().setColor(r8);
    L16:
        com.larksuite.component.card.cardcontainer.c r10 = (com.larksuite.component.card.cardcontainer.c) getContext().getSharedData("card_share_data", com.larksuite.component.card.cardcontainer.c.class);
        if (r10 == null) goto L21;
        CardContext r11 = r10.c;
        if (r11 == null) goto L21;
        r1 = r11.getDependency();
    L21:
        PersonListLynxUI.b r12 = new PersonListLynxUI.b(this, r1);
        Intrinsics.checkNotNullParameter(r12, "clickPersonListener");
        this.y = r12;
        q();
        return;
    L5:
        th = move-exception;
        Log.e("PersonListShadowNode", "props from lynx transform failed", th);
        r5 = null;
        goto L7
    }

    public final void w(LynxContext r3) {
        ((ShadowNode) this).m = r3;
        if (r3 == null) goto L6;
        AppCompatTextView r0 = new AppCompatTextView(r3.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextPaint r4 = r0.getPaint();
        g.a.getClass();
        r4.setTextSize(g.h(null));
        this.v = r0;
        return;
    }

    public final void f(int r1, int r2) {
        TraceEvent.beginSection("PersonListShadowNode.onLayout");
        ((LayoutNode) this).e = false;
        TraceEvent.endSection("PersonListShadowNode.onLayout");
    }

    public final long c(LayoutNode r63, float r64, MeasureMode r65, float r66, MeasureMode r67) {
        MeasureMode r0 = r65;
        String r5 = "PersonListShadowNode.measure";
        TraceEvent.beginSection("PersonListShadowNode.measure");
        Log.d("PersonListShadowNode", "\n***************** measure start **********************\n");
        Log.d("PersonListShadowNode", "\n***************** origin width: " + r64 + " height:" + r66 + "  widthMode:" + r0 + "  heightMode:" + r67 + " **********************\n");
        MeasureMode r6 = MeasureMode.UNDEFINED;
        Float r14 = Float.valueOf(0.0f);
        if (r0 == r6) goto L17;
        if (r67 == r6) goto L17;
        if (r64 != 0.0f) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == false) goto L17;
        if (r66 != 0.0f) goto L13;
        boolean r9 = true;
    L14:
        if (r9 == false) goto L17;
        return i.b(0, 0);
    L13:
        r9 = false;
        goto L14
    L8:
        r8 = false;
    L17:
        MeasureMode r10 = MeasureMode.EXACTLY;
        if (r0 == r10) goto L20;
    L25:
        float r12 = 32767.0f;
    L27:
        if (r64 != 0.0f) goto L29;
        boolean r11 = true;
    L30:
        if (r11 == false) goto L33;
        if (r0 != r6) goto L33;
        r0 = MeasureMode.AT_MOST;
    L33:
        MeasureMode r7 = r0;
        if (r67 == r10) goto L36;
    L41:
        float r13 = 32767.0f;
    L42:
        if (r67 == r10) goto L44;
    L49:
        r10 = MeasureMode.AT_MOST;
    L50:
        MeasureMode r43 = r10;
        PersonListProps r15 = this.x;
        if (r15 != null) goto L53;
    L331:
        r5 = "PersonListShadowNode.measure";
    L332:
        float r2 = r64;
    L333:
        float r1 = r66;
    L334:
        TraceEvent.endSection(r5);
        return i.a(r2, r1);
    L53:
        if (this.v == null) goto L331;
        Integer r3 = r15.getLines();
        TextView r45 = null;
        if (r3 != null) goto L57;
    L68:
        TextView r4 = this.v;
        if (r4 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r4 = null;
    L71:
        r4.setMaxLines(LKUIToast.DURATION_MAX);
    L72:
        int r16 = h.a;
        TextView r17 = this.v;
        if (r17 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r17 = null;
    L75:
        Context r19 = r17.getContext();
        TextView r20 = this.v;
        if (r20 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r20 = null;
    L78:
        TextPaint r21 = r20.getPaint();
        PersonListLynxUI.a r22 = this.z;
        float r68 = r13;
        com.larksuite.component.card.component.personlist.b r110 = this.y;
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r21, "paint");
        Intrinsics.checkNotNullParameter(r15, "props");
        if (r15.getLines() != null) goto L81;
    L83:
        int r111 = 100;
    L85:
        if (r15.getPersons().isEmpty() == false) goto L87;
        float r23 = r68;
        r5 = "PersonListShadowNode.measure";
        MeasureMode r52 = r7;
        float r24 = r12;
        SpannableStringBuilder r25 = null;
    L308:
        if (r25 == null) goto L332;
        if (r52 == null) goto L332;
        this.w = r25;
        TextView r26 = this.v;
        if (r26 != null) goto L313;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r26 = null;
    L313:
        r26.setText(r25);
        TextView r27 = this.v;
        if (r27 != null) goto L316;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r27 = null;
    L316:
        r27.measure(View.MeasureSpec.makeMeasureSpec((int) r24, C(r52)), View.MeasureSpec.makeMeasureSpec((int) r23, C(r43)));
        MeasureMode r29 = MeasureMode.EXACTLY;
        if (r52 == r29) goto L322;
        TextView r30 = this.v;
        if (r30 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r30 = null;
    L321:
        r2 = r30.getMeasuredWidth();
    L324:
        if (r67 == r29) goto L333;
        TextView r31 = this.v;
        if (r31 != null) goto L328;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L329:
        r1 = r45.getMeasuredHeight();
        goto L334
    L328:
        r45 = r31;
        goto L329
    L322:
        r2 = r64;
        goto L324
    L87:
        String r112 = UIHelper.getString(2131892752);
        int r32 = r15.getPersons().size();
        SpannableStringBuilder r33 = new SpannableStringBuilder();
        g.a.getClass();
        boolean r47 = g.i(r15);
        int r48 = g.g(r15);
        int r49 = g.d(r15);
        int r50 = g.e(r15);
        PersonStyle r34 = r15.getStyles();
        if (r34 == null) goto L105;
        String r35 = r34.getMoreTextColor();
        if (r35 == null) goto L105;
        if (r35.length() <= 0) goto L94;
        boolean r113 = true;
    L95:
        if (r113 == true) goto L98;
        r35 = null;
    L98:
        if (r35 == null) goto L105;
        int r36 = Color.parseColor(r35);     // Catch: Throwable -> L101
        r5 = "PersonListShadowNode.measure";
    L108:
        g.a.getClass();
        int r37 = g.b(r15);
        PersonStyle r38 = r15.getStyles();
        if (r38 == null) goto L121;
        PersonMargin r39 = r38.getMargin();
        if (r39 == null) goto L121;
        Integer r40 = Integer.valueOf(r39.getRight());
        if (r40.intValue() <= 0) goto L115;
        boolean r114 = true;
    L116:
        if (r114 == true) goto L119;
        r40 = null;
    L119:
        if (r40 == null) goto L121;
        float r41 = zz7.b.j(UIHelper.dp2px(r40.intValue()));
    L135:
        int r42 = (int) r41;
        PersonStyle r44 = r15.getStyles();
        if (r44 == null) goto L148;
        PersonMargin r46 = r44.getMargin();
        if (r46 == null) goto L148;
        Integer r51 = Integer.valueOf(r46.getTop());
        if (r51.intValue() <= 0) goto L142;
        boolean r115 = true;
    L143:
        if (r115 == true) goto L146;
        r51 = null;
    L146:
        if (r51 == null) goto L148;
        float r53 = zz7.b.j(UIHelper.dp2px(r51.intValue()));
        r52 = r7;
    L163:
        int r54 = (int) r53;
        int r55 = g.c(r15);
        PersonStyle r116 = r15.getStyles();
        if (r116 == null) goto L174;
        Integer r117 = Integer.valueOf(r116.getNameLineHeight());
        if (r117.intValue() <= 0) goto L168;
        boolean r118 = true;
    L169:
        if (r118 == true) goto L172;
        r117 = null;
    L172:
        if (r117 == null) goto L174;
        int r119 = UIHelper.dp2px(r117.intValue());
    L175:
        if (r47 == false) goto L177;
        float r56 = r42;
    L178:
        if (r47 == false) goto L180;
        int r120 = r49 + g.d;
    L181:
        float r57 = r56;
        int r59 = 0;
        int r60 = 1;
        float r510 = 0.0f;
    L182:
        if (r60 > r111) goto L291;
        if (r59 >= r32) goto L291;
        int r511 = r119;
        PersonInfo r121 = (PersonInfo) ListProtector.get(r15.getPersons(), r59);
        g.a.getClass();
        String r122 = g.f(r121);
        int r61 = r55;
        if (r59 != (r32 - 1)) goto L187;
        boolean r62 = true;
    L188:
        int r69 = r32;
        float r123 = r21.measureText(r122) + r120;
        if (r62 == true) goto L191;
        float r70 = r57;
    L192:
        float r71 = r70 + r123;
        float r72 = r12 - r510;
        List<PersonInfo> r124 = r15.getPersons();
        Intrinsics.checkNotNull(r112);
        float r310 = r510 + r71;
        if (r60 != r111) goto L195;
        boolean r311 = true;
    L197:
        if (r71 <= r12) goto L199;
        boolean r312 = true;
    L200:
        h.d r125 = new h.d(r19, r21, r124, r112, r12, r49, r42, r54, r37, r50, r36, r61, r511, r48, r71, r57, r310, r311, r60, r59, r72, r312, r47, r120, r22, r110);
        int r126 = r36;
        if (r71 <= r72) goto L242;
        PersonInfo r73 = (PersonInfo) ListProtector.get(r125.c, r125.t);
        String r74 = g.f(r73);
        int r127 = r42;
        if (r125.t != (r125.c.size() - 1)) goto L205;
        boolean r75 = true;
    L206:
        if (r75 == true) goto L208;
    L217:
        int r128 = r37;
        int r210 = r54;
        SpannableStringBuilder r76 = r33;
        if (r125.r == false) goto L223;
        h.a(r76, r125);
        h.a r77 = new h.a(false, null, false, true, 7);
    L220:
        r23 = r68;
        TextPaint r211 = r21;
        Context r212 = r19;
        PersonListProps r213 = r15;
        int r410 = r120;
        r24 = r12;
        int r214 = r111;
        com.larksuite.component.card.component.personlist.b r215 = r110;
    L279:
        if (r77.d == true) goto L292;
        if (r77.c == false) goto L285;
        r60 = r60 + 1;
    L285:
        if (r77.a == false) goto L287;
        r59 = r59 + 1;
    L287:
        Float r79 = r77.b;
        if (r79 == null) goto L290;
        r510 = r79.floatValue();
    L290:
        r68 = r23;
        r33 = r76;
        r12 = r24;
        r36 = r126;
        r42 = r127;
        r37 = r128;
        r54 = r210;
        r21 = r211;
        r19 = r212;
        r15 = r213;
        r110 = r215;
        r111 = r214;
        r120 = r410;
        r119 = r511;
        r55 = r61;
        r32 = r69;
    L292:
        com.larksuite.component.card.component.personlist.avatar.a[] r80 = (com.larksuite.component.card.component.personlist.avatar.a[]) r76.getSpans(0, r76.length(), com.larksuite.component.card.component.personlist.avatar.a.class);
        if (r80 == null) goto L307;
        int r81 = r80.length;
        int r129 = 0;
    L295:
        if (r129 >= r81) goto L307;
        com.larksuite.component.card.component.personlist.avatar.a r82 = r80[r129];
        if (TextUtils.isEmpty(r82.h) == false) goto L306;
        if (TextUtils.isEmpty(r82.i) == true) goto L306;
        String r83 = r82.i;
        if (r83 == null) goto L306;
        Lazy<SimpleUserLoader> r84 = SimpleUserLoader.d;
        SimpleUserLoader r85 = SimpleUserLoader.a.a();
        Intrinsics.checkNotNull(r82);
        r85.getClass();
        Intrinsics.checkNotNullParameter(r83, "userId");
        Intrinsics.checkNotNullParameter(r82, "listener");
        ArrayList<WeakReference<com.larksuite.component.card.component.personlist.avatar.c>> r86 = (ArrayList) ((LinkedHashMap) r85.c).get(r83);
        if (r86 != null) goto L305;
        r86 = new ArrayList();
        r85.c.put(r83, r86);
    L305:
        r86.add(new WeakReference(r82));
    L306:
        r129 = r129 + 1;
    L307:
        r25 = r76;
        goto L308
    L223:
        if (r125.v == false) goto L241;
        r211 = r21;
        r212 = r19;
        CharSequence r87 = TextUtils.ellipsize(r74, r125.b, (r125.u - r125.p) - r125.x, TextUtils.TruncateAt.END);
        CharSequence r216 = r74.subSequence(0, 1);
        Intrinsics.checkNotNull(r87);
        if (StringsKt.lastIndexOf$default(r87, r216.toString(), 0, false, 6, null) == (-1)) goto L227;
        boolean r88 = true;
    L228:
        r213 = r15;
        int r217 = r120;
        CharSequence r313 = TextUtils.ellipsize(r74, r125.b, (r125.e - r125.p) - r125.x, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r313);
        if (StringsKt.lastIndexOf$default(r313, r216.toString(), 0, false, 6, null) == (-1)) goto L231;
        boolean r89 = true;
    L232:
        if (r88 == false) goto L234;
        h.b(r76, r87.toString(), r73, r75, r125);
        r76.append("\n");
        r410 = r217;
        r215 = r110;
        r214 = r111;
        r77 = new h.a(true, r14, true, false, 8);
        r23 = r68;
        r24 = r12;
        goto L279
    L234:
        r23 = r68;
        r214 = r111;
        r410 = r217;
        r215 = r110;
        float r130 = r12;
        if (r89 == false) goto L237;
        r76.append("\n");
        r24 = r130;
        r77 = new h.a(false, r14, true, false, 9);
        goto L279
    L237:
        r24 = r130;
        if (r125.u >= r125.e) goto L240;
        r76.append("\n");
    L240:
        h.a(r76, r125);
        r77 = new h.a(false, null, false, true, 7);
        goto L279
    L231:
        r89 = false;
        goto L232
    L227:
        r88 = false;
        goto L228
    L241:
        r23 = r68;
        r211 = r21;
        r212 = r19;
        r213 = r15;
        r410 = r120;
        r24 = r12;
        r214 = r111;
        r215 = r110;
        r76.append("\n");
        r77 = new h.a(false, r14, true, false, 9);
        goto L279
    L208:
        if (r125.r == false) goto L217;
        r128 = r37;
        float r90 = r125.u - r125.x;
        r210 = r54;
        CharSequence r91 = TextUtils.ellipsize(r74, r125.b, r90, TextUtils.TruncateAt.END);
        if (r125.w == true) goto L212;
    L216:
        String r92 = r91.toString();
        r76 = r33;
        h.b(r76, r92, r73, r75, r125);
        r77 = new h.a(true, null, false, true, 6);
        goto L220
    L212:
        if (TextUtils.equals(r91, "") == false) goto L216;
        if (r125.b.measureText("...") > r90) goto L216;
        r91 = "...";
        goto L216
    L205:
        r75 = false;
        goto L206
    L242:
        r23 = r68;
        r127 = r42;
        r128 = r37;
        r210 = r54;
        r211 = r21;
        r212 = r19;
        r213 = r15;
        r410 = r120;
        r24 = r12;
        r214 = r111;
        r76 = r33;
        r215 = r110;
        PersonInfo r93 = (PersonInfo) ListProtector.get(r125.c, r125.t);
        String r94 = g.f(r93);
        int r95 = r125.c.size();
        int r96 = r125.t;
        int r131 = r95 - 1;
        if (r96 != r131) goto L245;
        boolean r132 = true;
    L246:
        if (r132 == false) goto L248;
    L277:
        h.b(r76, r94, r93, r132, r125);
        r77 = new h.a(true, Float.valueOf(r125.q), false, false, 12);
        goto L279
    L248:
        if (r125.r == false) goto L277;
        if (r96 != (r95 - 2)) goto L265;
        String r97 = g.f((PersonInfo) ListProtector.get(r125.c, r131));
        CharSequence r133 = r97.subSequence(0, 1);
        if (r125.w == true) goto L257;
        String r98 = r94 + r125.d;
        CharSequence r218 = TextUtils.ellipsize(r98 + r97, r125.b, r125.u, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r218);
        if (StringsKt.lastIndexOf$default(r218, r98 + r133, 0, false, 6, null) != (-1)) goto L259;
    L260:
        boolean r99 = false;
    L261:
        if (r99 == false) goto L263;
        h.b(r76, r94, r93, r132, r125);
        r77 = new h.a(true, Float.valueOf(r125.q), false, false, 12);
        goto L279
    L263:
        h.a(r76, r125);
        r77 = new h.a(false, null, false, true, 7);
    L259:
        r99 = true;
        goto L261
    L257:
        CharSequence r219 = TextUtils.ellipsize(r97, r125.b, (r125.u - r125.o) - r125.x, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r219);
        if (StringsKt.lastIndexOf$default(r219, String.valueOf(r133), 0, false, 6, null) == (-1)) goto L260;
    L265:
        if (r125.w == false) goto L271;
        if ((r125.o + r125.f) >= r125.u) goto L273;
    L272:
        boolean r100 = true;
    L274:
        if (r100 == false) goto L276;
        h.b(r76, r94, r93, r132, r125);
        r77 = new h.a(true, Float.valueOf(r125.q), false, false, 12);
        goto L279
    L276:
        h.a(r76, r125);
        r77 = new h.a(false, null, false, true, 7);
    L273:
        r100 = false;
        goto L274
    L271:
        if (r125.b.measureText(r94 + r125.d + h.c(String.valueOf((r95 - r96) - 1))) >= r125.u) goto L273;
    L245:
        r132 = false;
        goto L246
    L199:
        r312 = false;
        goto L200
    L195:
        r311 = false;
        goto L197
    L191:
        r70 = 0.0f;
        goto L192
    L187:
        r62 = false;
    L291:
        r23 = r68;
        r24 = r12;
        r76 = r33;
        goto L292
    L180:
        r120 = 0;
        goto L181
    L177:
        r56 = r21.measureText(r112);
        goto L178
    L168:
        r118 = false;
    L174:
        r119 = ((int) g.h(r15)) + g.e;
        goto L175
    L142:
        r115 = false;
    L148:
        PersonStyle r101 = r15.getStyles();
        if (r101 == null) goto L161;
        Integer r102 = Integer.valueOf(r101.getAvatarSize());
        r52 = r7;
        int r103 = r102.intValue();
        if (r103 > 0) goto L153;
    L155:
        boolean r104 = false;
    L156:
        if (r104 == true) goto L159;
        r102 = null;
    L159:
        if (r102 == null) goto L162;
        r102.intValue();
        r53 = zz7.b.j(g.c);
    L162:
        r53 = zz7.b.j(g.b);
        goto L163
    L153:
        if (r103 > 32.0f) goto L155;
        r104 = true;
        goto L156
    L161:
        r52 = r7;
        goto L162
    L115:
        r114 = false;
    L121:
        PersonStyle r105 = r15.getStyles();
        if (r105 == null) goto L134;
        Integer r106 = Integer.valueOf(r105.getAvatarSize());
        int r107 = r106.intValue();
        if (r107 > 0) goto L126;
    L128:
        boolean r108 = false;
    L129:
        if (r108 == true) goto L132;
        r106 = null;
    L132:
        if (r106 == null) goto L134;
        r106.intValue();
        r41 = zz7.b.j(g.c);
        goto L135
    L126:
        if (r107 > 32.0f) goto L128;
        r108 = true;
    L134:
        r41 = zz7.b.j(g.b);
    L101:
        th = move-exception;
        Log.e("PersonListUtils", "parse more text Color failed", th);
        goto L105
    L94:
        r113 = false;
    L105:
        if (g.i(r15) == false) goto L107;
        r36 = UIHelper.getColor(2131106607);
        goto L108
    L107:
        r36 = UIHelper.getColor(2131106614);
        goto L108
    L81:
        if (r15.getLines().intValue() <= 0) goto L83;
        r111 = r15.getLines().intValue();
        goto L85
    L57:
        if (r3.intValue() <= 0) goto L59;
        boolean r109 = true;
    L60:
        if (r109 == true) goto L63;
        r3 = null;
    L63:
        if (r3 == null) goto L68;
        int r134 = r3.intValue();
        TextView r135 = this.v;
        if (r135 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r135 = null;
    L67:
        r135.setMaxLines(r134);
        goto L72
    L59:
        r109 = false;
        goto L60
    L44:
        if (r66 != 0.0f) goto L46;
        boolean r136 = true;
    L47:
        if (r136 == true) goto L49;
    L46:
        r136 = false;
        goto L47
    L36:
        if (r66 != 0.0f) goto L38;
        boolean r137 = true;
    L39:
        if (r137 == true) goto L41;
        r13 = r66;
        goto L42
    L38:
        r137 = false;
        goto L39
    L29:
        r11 = false;
        goto L30
    L20:
        if (r64 != 0.0f) goto L22;
        boolean r138 = true;
    L23:
        if (r138 == true) goto L25;
        r12 = r64;
        goto L27
    L22:
        r138 = false;
        goto L23
    }
}
