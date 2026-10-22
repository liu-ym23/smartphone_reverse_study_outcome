package com.larus.bmhome.chat.component.input;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.g9;
import com.larus.bmhome.chat.component.bottom.core.h9;
import com.larus.bmhome.chat.component.bottom.core.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0014\u0010\u0019\u001a\u00020\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/component/input/PhotoPickerInjectInputComponent;", "Lcom/larus/bmhome/chat/component/input/InjectInputComponent;", "<init>", "()V", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "Lkotlin/Lazy;", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "inputTextChangedListener", "com/larus/bmhome/chat/component/input/PhotoPickerInjectInputComponent$inputTextChangedListener$1", "Lcom/larus/bmhome/chat/component/input/PhotoPickerInjectInputComponent$inputTextChangedListener$1;", "onViewCreated", "", "view", "Landroid/view/View;", "onResume", "onPause", "refreshActionEntrance", "renderCameraActionEntrance", "content", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class PhotoPickerInjectInputComponent extends InjectInputComponent {
    public static final /* synthetic */ int u = 0;
    public final Lazy r;
    public final Lazy s;
    public final a t;

    public static final class a implements ICoreInputAbility.e {
        public final /* synthetic */ PhotoPickerInjectInputComponent a;

        public a(PhotoPickerInjectInputComponent r1) {
            this.a = r1;
        }

        public final void h(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }

        public final void i(String r3) {
            Intrinsics.checkNotNullParameter(r3, "content");
            PhotoPickerInjectInputComponent r0 = this.a;
            int r1 = PhotoPickerInjectInputComponent.u;
            r0.p3(r3);
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, "content");
        }
    }

    public PhotoPickerInjectInputComponent() {
        this.r = LazyKt.lazy(new y0(this));
        this.s = LazyKt.lazy(new z0(this));
        this.t = new a(this);
    }

    public final void onPause() {
        ICoreInputAbility r0 = Y2();
        if (r0 == null) goto L6;
        r0.Vs(this.t);
        return;
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void onResume() {
        super.onResume();
        ICoreInputAbility r0 = Y2();
        if (r0 == null) goto L5;
        r0.QG(this.t);
    L5:
        z3(this);
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void o8() {
        z3(this);
    }

    public static /* synthetic */ void z3(PhotoPickerInjectInputComponent r1) {
        ICoreInputAbility r0 = r1.Y2();
        if (r0 == null) goto L5;
        String r2 = r0.N5();
    L6:
        r1.p3(r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.input.InjectInputComponent
    public final void onViewCreated(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4);
        z8 r5 = h3();
        if (r5 == null) goto L5;
        r5.S8(true);
    L5:
        z8 r6 = h3();
        if (r6 == null) goto L8;
        r6.C8(true);
    L8:
        z8 r7 = h3();
        if (r7 == null) goto L11;
        r7.W8(new z8.c(new w0(this), new x0()));
    L11:
        z3(this);
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, java.lang.Object] */
    public final void p3(String r5) {
        ICoreInputAbility r0 = Y2();
        if (r0 == null) goto L32;
        g9.c r1 = r0.q20();
        if (r1 == null) goto L33;
        va8.o r2 = (va8.o) this.s.getValue();
        if (r2 == null) goto L27;
        boolean r3 = true;
        if (r5 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L26;
        ICoreInputAbility r7 = Y2();
        if (r7 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L26;
        r3 = false;
        goto L26
    L20:
        if (r7.J8() != true) goto L22;
        r8 = true;
    L26:
        r2.k3(r3);
        goto L27
    L12:
        if (r5.length() == 0) goto L15;
        r6 = false;
    L27:
        h9 r9 = r1.a();
        int r4 = com.larus.utils.j0.a;
        String r10 = com.larus.utils.j0.d(2131898808);
        Intrinsics.checkNotNullParameter(r10, "contentDescription");
        ?? r11 = r9.a;
        if (r11 == 0) goto L30;
        r11.setContentDescription(r10);
    L30:
        r1.c().e(false);
        r1.b().c(v19.c.b(2130971931, getContext(), 2131242482));
        return;
    L33:
        return;
    }
}
