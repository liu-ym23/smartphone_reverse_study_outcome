package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.im.bean.message.Message;
import com.larus.image.databinding.LarusLayoutCreationSideBarBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJv\u0010)\u001a\u00020&2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJF\u0010*\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010,\u001a\u00020\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010#J\u0018\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0017J\u000e\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u0017J\b\u00104\u001a\u00020&H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082D¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/CreationSidebarView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutCreationSideBarBinding;", "aiImageParams", "Lcom/larus/bmhome/chat/bean/AIEditParams;", "aiVideoParams", "aiImageExpandParams", "aiImageErasePrams", "aiImageSharepnessParams", "currentValidUri", "Landroid/net/Uri;", "imageData", "Lcom/larus/bmhome/bigimg/ImageData;", "currentIsVideo", "", "Ljava/lang/Boolean;", "videoData", "Lcom/larus/platform/model/video/VideoPlayData;", "aiVideoExtendParams", "needShowEditView", "isShowShare", "functionVisibleConfig", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;", "currentMessage", "Lcom/larus/im/bean/message/Message;", "currentDriveInfo", "Lcom/larus/bmhome/chat/bean/DriveImageExtraInfo;", "onShareClickListener", "Lkotlin/Function0;", "", "logTag", "", "initData", "bindData", "message", "showEditView", "driveInfo", "updateImageEditPanelAlpha", "alpha", "", "ignoreShareIcon", "updateSharpnessState", "enabled", "bindEditPanel", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CreationSidebarView extends ConstraintLayout {
    public final LarusLayoutCreationSideBarBinding a;
    public ic8.d b;
    public ic8.d c;
    public ic8.d d;
    public ic8.d e;
    public ic8.d f;
    public Uri g;
    public m1 h;
    public Boolean i;
    public nr9.g j;
    public ic8.d k;
    public Boolean l;
    public boolean m;
    public LeftCreationEditView.b n;
    public Message o;
    public ic8.r p;
    public Function0<Unit> q;
    public final String r;

    public CreationSidebarView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CreationSidebarView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void T5(boolean r6) {
        if (r6 == false) goto L4;
        float r0 = 1.0f;
    L5:
        LeftCreationEditView r1 = this.a.b;
        ConstraintLayout r2 = r1.f;
        View r3 = null;
        if (r2 == null) goto L8;
        ViewParent r4 = r2.getParent();
    L10:
        if ((r4 instanceof View) == false) goto L12;
        r3 = (View) r4;
    L12:
        if (r3 == null) goto L14;
        r3.setAlpha(r0);
    L14:
        ConstraintLayout r5 = r1.f;
        if (r5 == null) goto L18;
        r5.setClickable(r6);
        return;
    L18:
        return;
    L8:
        r4 = null;
        goto L10
    L4:
        r0 = 0.5f;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationSidebarView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562797, this);
        LeftCreationEditView r5 = (LeftCreationEditView) ViewBindings.findChildViewById(this, 2131377763);
        if (r5 == null) goto L7;
        this.a = new LarusLayoutCreationSideBarBinding(this, r5);
        this.m = true;
        this.r = "CreationSidebarView";
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(2131377763)));
    }

    public /* synthetic */ CreationSidebarView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static void R5(CreationSidebarView r16, Uri r17, m1 r18, nr9.g r19, Message r20, boolean r21, ic8.r r22, int r23) {
        Boolean r3 = null;
        if ((r23 & 8) == 0) goto L5;
        Message r2 = null;
    L6:
        boolean r5 = true;
        if ((r23 & 16) == 0) goto L9;
        boolean r4 = true;
    L11:
        if ((r23 & 32) == 0) goto L13;
        ic8.r r7 = null;
    L14:
        r16.g = r17;
        r16.h = r18;
        r16.j = r19;
        r16.o = r2;
        r16.p = r7;
        if (r19 == null) goto L17;
        boolean r1 = true;
    L18:
        boolean r8 = !Intrinsics.areEqual(r16.l, Boolean.valueOf(r4));
        boolean r9 = !Intrinsics.areEqual(r16.i, Boolean.valueOf(r1));
        r16.l = Boolean.valueOf(r4);
        r16.i = Boolean.valueOf(r1);
        FLogger r10 = FLogger.a;
        r10.i(r16.r, "bindData: showEditView " + r4 + " isVideo " + r1);
        if (r8 == true) goto L21;
        if (r9 == true) goto L21;
        return;
    L21:
        String r6 = r16.r;
        StringBuilder r11 = new StringBuilder("bindEditPanel ");
        ic8.d r12 = r16.b;
        if (r12 == null) goto L24;
        Boolean r13 = Boolean.valueOf(r12.a);
    L25:
        r11.append(r13);
        r11.append(' ');
        ic8.d r14 = r16.c;
        if (r14 == null) goto L28;
        r3 = Boolean.valueOf(r14.a);
    L28:
        r11.append(r3);
        r11.append(',');
        r10.i(r6, r11.toString());
        if (Intrinsics.areEqual(r16.i, Boolean.TRUE) == false) goto L36;
        ic8.d r15 = r16.k;
        if (r15 == null) goto L33;
        boolean r24 = r15.a;
    L34:
        if (r24 == false) goto L36;
        boolean r25 = true;
    L37:
        boolean r26 = Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1");
        LeftCreationEditView r27 = r16.a.b;
        i r28 = new i(r16);
        Boolean r29 = r16.i;
        Boolean r110 = Boolean.FALSE;
        if (Intrinsics.areEqual(r29, r110) == false) goto L48;
        ic8.d r30 = r16.c;
        if (r30 == null) goto L42;
        boolean r31 = r30.a;
    L43:
        if (r31 == false) goto L48;
        if (Intrinsics.areEqual(r16.l, r110) == true) goto L48;
        if (r26 == true) goto L48;
        boolean r111 = true;
    L50:
        if (Intrinsics.areEqual(r16.i, r110) == false) goto L60;
        ic8.d r32 = r16.b;
        if (r32 == null) goto L54;
        boolean r33 = r32.a;
    L55:
        if (r33 == false) goto L60;
        if (Intrinsics.areEqual(r16.l, r110) == true) goto L60;
        if (r26 == true) goto L60;
        boolean r34 = true;
    L62:
        if (r16.m == false) goto L64;
        z2.a.w3();
        boolean r112 = true;
    L65:
        LeftCreationEditView.d(r27, r28, null, r34, false, r111, r25, r112, r16.n, 10);
        if (Intrinsics.areEqual(r16.l, r110) == true) goto L134;
        ic8.d r35 = r16.b;
        if (r35 != null) goto L71;
    L73:
        boolean r36 = false;
    L74:
        if (r36 == false) goto L79;
        if (r35 == null) goto L79;
        Function1<ic8.f, Unit> r37 = r35.c;
        if (r37 == null) goto L79;
        r37.invoke(new ic8.f(null, r16.o, null, null, null, 61));
    L79:
        ic8.d r38 = r16.d;
        if (r38 != null) goto L82;
    L84:
        boolean r39 = false;
    L85:
        if (r39 == false) goto L90;
        if (r38 == null) goto L90;
        Function1<ic8.f, Unit> r40 = r38.c;
        if (r40 == null) goto L90;
        r40.invoke(new ic8.f(null, r16.o, null, null, null, 61));
    L90:
        ic8.d r41 = r16.e;
        if (r41 != null) goto L93;
    L95:
        boolean r42 = false;
    L96:
        if (r42 == false) goto L101;
        if (r41 == null) goto L101;
        Function1<ic8.f, Unit> r43 = r41.c;
        if (r43 == null) goto L101;
        r43.invoke(new ic8.f(null, r16.o, null, null, null, 61));
    L101:
        ic8.d r44 = r16.f;
        if (r44 != null) goto L104;
    L106:
        boolean r45 = false;
    L107:
        if (r45 == false) goto L112;
        if (r44 == null) goto L112;
        Function1<ic8.f, Unit> r46 = r44.c;
        if (r46 == null) goto L112;
        r46.invoke(new ic8.f(null, r16.o, null, null, null, 61));
    L112:
        ic8.d r47 = r16.c;
        if (r47 != null) goto L115;
    L117:
        r5 = false;
    L118:
        if (r5 == false) goto L123;
        if (r47 == null) goto L123;
        Function1<ic8.f, Unit> r48 = r47.c;
        if (r48 == null) goto L123;
        r48.invoke(new ic8.f(null, r16.o, null, null, null, 61));
    L123:
        if (r25 == false) goto L131;
        ic8.d r49 = r16.k;
        if (r49 == null) goto L132;
        Function1<ic8.f, Unit> r50 = r49.c;
        if (r50 == null) goto L133;
        r50.invoke(new ic8.f(null, r16.o, null, null, null, 61));
        return;
    L133:
        return;
    L132:
        return;
    L131:
        return;
    L115:
        if (r47.a != true) goto L117;
    L104:
        if (r44.a != true) goto L106;
        r45 = true;
        goto L107
    L93:
        if (r41.a != true) goto L95;
        r42 = true;
        goto L96
    L82:
        if (r38.a != true) goto L84;
        r39 = true;
        goto L85
    L71:
        if (r35.a != true) goto L73;
        r36 = true;
        goto L74
    L134:
        return;
    L64:
        r112 = false;
        goto L65
    L54:
        r33 = false;
    L60:
        r34 = false;
        goto L62
    L42:
        r31 = false;
    L48:
        r111 = false;
        goto L50
    L33:
        r24 = false;
    L36:
        r25 = false;
        goto L37
    L24:
        r13 = null;
        goto L25
    L17:
        r1 = false;
        goto L18
    L13:
        r7 = r22;
        goto L14
    L9:
        r4 = r21;
        goto L11
    L5:
        r2 = r20;
        goto L6
    }

    public static void S5(CreationSidebarView r2, ic8.d r3, ic8.d r4, ic8.d r5, ic8.d r6, ic8.d r7, ic8.d r8, Function0 r9, LeftCreationEditView.b r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 128) == 0) goto L26;
        boolean r0 = true;
    L28:
        if ((r11 & 256) == 0) goto L30;
        r10 = null;
    L30:
        r2.b = r3;
        r2.c = r4;
        r2.d = r5;
        r2.e = r6;
        r2.f = r7;
        r2.k = r8;
        r2.q = r9;
        r2.m = r0;
        r2.n = r10;
        return;
    L26:
        r0 = false;
        goto L28
    }
}
