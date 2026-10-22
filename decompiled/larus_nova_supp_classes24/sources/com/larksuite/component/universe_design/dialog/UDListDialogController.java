package com.larksuite.component.universe_design.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.component.universe_design.util.UDDividerItemDecoration;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UDListDialogController extends UDDialogController {
    public OnItemClickListener a;
    public List<UDBaseListDialogBuilder.ListItem> b;
    public int c;
    public int d;
    public int e;
    public int f;
    public UDBaseListDialogAdapter g;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "", "onItemClick", "", "index", "", "universe-ui-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public interface OnItemClickListener {
        void onItemClick(int r1);
    }

    public static final class a implements OnItemClickListener {
        public final /* synthetic */ UDListDialogController a;

        public a(UDListDialogController r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [android.app.Dialog, com.larksuite.component.universe_design.dialog.UDDialog, java.lang.Object] */
        @Override // com.larksuite.component.universe_design.dialog.UDListDialogController.OnItemClickListener
        public final void onItemClick(int r5) {
            if (this.a.getMAutoDismiss() == false) goto L23;
            ?? r0 = this.a.getMDialog();
            if (r0 == 0) goto L23;
            Handler r1 = DialogLancet.resolveDialogHandler(r0);
            if (r1 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r0);
            r0.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r0);
            goto L23
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r2 == null) goto L20;
            com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r0);
            throw th;
        L9:
            if (Looper.myLooper() == r1.getLooper()) goto L11;
            r1.post(DialogLancet.createDismissRunnable(r0));
        L23:
            OnItemClickListener r3 = this.a.a;
            if (r3 == null) goto L30;
            r3.onItemClick(r5);
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return 2131568073;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultFooterRes() {
        return 2131568074;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultHeaderRes() {
        setHeaderLayoutDefault$universe_ui_dialog_release(true);
        return 2131568075;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public int getDefaultRootRes() {
        return 2131568077;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View createView() {
        View r0 = super.createView();
        if (isHeaderVisible$universe_ui_dialog_release() == true) goto L8;
        if (r0 == null) goto L8;
        View r1 = r0.findViewById(2131391769);
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        return r0;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public View onCreateContent() {
        View r0 = getFinalView(getMContentLayout(), getMContentLayoutRes(), 2131568073);
        UDBaseListDialogAdapter r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        RecyclerView r2 = r0.findViewById(2131391770);
        if (r2 == null) goto L15;
        UDBaseListDialogAdapter r3 = this.g;
        if (r3 == null) goto L14;
        int r4 = this.f;
        if (r4 != (-1)) goto L13;
        r4 = 2131568076;
    L13:
        r3.d = r4;
        r3.A2(this.b);
        r3.c = new a(this);
        r3.g = this.e;
        r3.f = this.d;
        r3.e = this.c;
        r3.h = !TextUtils.isEmpty(getMTitle());
        r1 = r3;
    L14:
        r2.setAdapter(r1);
        r2.setLayoutManager(new LinearLayoutManager(getContext()));
        UDDividerItemDecoration r5 = new UDDividerItemDecoration();
        Drawable r6 = UDIconUtils.getIconDrawable(getContext(), 2131253521);
        Intrinsics.checkNotNullParameter(r6, "drawable");
        r5.a = r6;
        r5.d = false;
        r2.addItemDecoration(r5);
    L15:
        return r0;
    }

    public UDListDialogController(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = new ArrayList();
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof UDBaseListDialogBuilder) == false) goto L10;
        super.apply(r2, r3);
        UDBaseListDialogBuilder r4 = (UDBaseListDialogBuilder) r2;
        this.a = r4.getMItemClickListener$universe_ui_dialog_release();
        this.b = r4.getMItems$universe_ui_dialog_release();
        this.c = r4.getMItemTextSize$universe_ui_dialog_release();
        this.d = r4.getMItemTextColorRes$universe_ui_dialog_release();
        this.e = r4.getMItemHeight$universe_ui_dialog_release();
        this.f = r4.getMItemLayoutRes$universe_ui_dialog_release();
        UDBaseListDialogAdapter r5 = r4.getMAdapter$universe_ui_dialog_release();
        if (r5 != null) goto L7;
        r5 = new UDBaseListDialogAdapter(getContext());
    L7:
        this.g = r5;
        return;
    L10:
        throw new IllegalArgumentException("builder should be UDBaseListDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
