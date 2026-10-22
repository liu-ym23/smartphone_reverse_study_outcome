package com.bytedance.android.live.liveinteract.enlarge.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.enlarge.dialog.diff.MultiEnlargeGuestSelectedItemDecoration;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import com.bytedance.android.live.liveinteract.plantform.datamerge.LinkUserDataMergeContext;
import com.bytedance.android.live.liveinteract.videotalk.cposition.CPositionContext;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/MultiLinkEnlargeSelectNewEnlargeUserDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkEnlargeSelectNewEnlargeUserDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int H = 0;
    public long B;
    public String C;
    public final CompositeDisposable D;
    public MultiTypeAdapter E;
    public List<MultiEnlargeGuestSelectViewBinder.b> F;
    public DataCenter G;

    public static final class a {
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565656;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super/*com.bytedance.android.livesdk.widget.LiveStandardSheetDialog*/.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.D.clear();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    public MultiLinkEnlargeSelectNewEnlargeUserDialog(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, false);
        this.C = "";
        this.D = new CompositeDisposable();
        this.F = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        ((TextView) findViewById(2131387762)).setOnClickListener(x0.a(new MultiLinkEnlargeSelectNewEnlargeUserDialog$initView$1(this)));
        MultiTypeAdapter r9 = new MultiTypeAdapter(this.F);
        this.E = r9;
        r9.z2(MultiEnlargeGuestSelectViewBinder.b.class, new MultiEnlargeGuestSelectViewBinder(new g(this)));
        SSGridLayoutManager r10 = new SSGridLayoutManager(getContext(), 4, 1);
        RecyclerView r1 = findViewById(2131374077);
        MultiTypeAdapter r3 = this.E;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L5:
        r1.setAdapter(r3);
        findViewById(2131374077).setLayoutManager(r10);
        findViewById(2131374077).addItemDecoration(new MultiEnlargeGuestSelectedItemDecoration());
        com.bytedance.android.live.liveinteract.plantform.datamerge.d r11 = LinkUserDataMergeContext.a.b(LinkUserDataMergeContext.Companion, this.G);
        if (r11 == null) goto L38;
        List r12 = (List) r11.f().getValue();
        if (r12 == null) goto L28;
        ArrayList r0 = new ArrayList();
        Iterator r13 = r12.iterator();
    L11:
        if (r13.hasNext() == false) goto L15;
        Object r2 = r13.next();
        if (((ch0.e) r2).a.isEnlarged() == true) goto L11;
        r0.add(r2);
        goto L11
    L15:
        List r14 = CollectionsKt.sortedWith(r0, new f());
        if (r14 == null) goto L28;
        List r15 = r14;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
        int r5 = 0;
    L19:
        if (r16.hasNext() == false) goto L29;
        Object r6 = r16.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        ch0.e r17 = (ch0.e) r6;
        if (r5 != 0) goto L26;
        MultiEnlargeGuestSelectViewBinder.b r18 = new MultiEnlargeGuestSelectViewBinder.b(true, r17.a);
    L27:
        r4.add(r18);
        r5 = r7;
        goto L19
    L26:
        r18 = new MultiEnlargeGuestSelectViewBinder.b(false, r17.a);
    L29:
        if (r4 == null) goto L31;
        this.F = r4;
    L31:
        MultiTypeAdapter r19 = this.E;
        if (r19 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L34:
        r19.a = this.F;
        MultiTypeAdapter r20 = this.E;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("selectedAdapter");
    L37:
        r20.notifyDataSetChanged();
    L28:
        r4 = null;
    L38:
        CPositionContext r21 = CPositionContext.Companion.getContext();
        if (r21 == null) goto L56;
        m<EnlargeGuestInfo> r22 = r21.getEnlargeGuestInfo();
        if (r22 == null) goto L57;
        Observable r23 = r22.a();
        if (r23 == null) goto L58;
        Disposable r24 = r23.subscribe(new h(this));
        if (r24 == null) goto L59;
        this.D.add(r24);
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    }
}
