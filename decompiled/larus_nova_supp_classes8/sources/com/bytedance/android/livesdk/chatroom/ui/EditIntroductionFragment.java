package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/EditIntroductionFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/chatroom/utils/d0;", "<init>", "()V", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EditIntroductionFragment extends LiveDialogFragment implements com.bytedance.android.livesdk.chatroom.utils.d0 {
    public static final /* synthetic */ int p = 0;
    public View d;
    public View e;
    public EditText f;
    public View g;
    public View h;
    public String i;
    public SpannableStringBuilder j;
    public n6 k;
    public final IdentityHashMap<String, s6> l;
    public boolean m;
    public int n;
    public final EditIntroductionFragment$imageGetter$1 o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ EditIntroductionFragment a;
        public final /* synthetic */ Function2 b;
        public final /* synthetic */ String c;

        public b(EditIntroductionFragment r1, Function2 r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            EditText r0 = this.a.f;
            if (r0 == null) goto L6;
            r0.post(new b6(this, r4));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ String b;

        public c(Function1 r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.invoke(this.b);
        }
    }

    public static final class d implements LiveBottomSheetDialog.m {
        public d() {
        }

        public final boolean disableDragDown() {
            return true;
        }

        public final boolean shouldInterceptSlide(int r1) {
            return false;
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {
        public final /* synthetic */ EditIntroductionFragment a;

        public e(EditIntroductionFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            EditIntroductionFragment r3 = this.a;
            EditIntroductionFragment.S90(r3, r3.i);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ EditIntroductionFragment a;
        public final /* synthetic */ Map b;

        public f(EditIntroductionFragment r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_info_filling_page_detail_done", this.b, new Object[0]);
            EditText r5 = this.a.f;
            if (r5 == null) goto L5;
            Editable r6 = r5.getText();
        L6:
            String r7 = Html.toHtml(r6);
            EditIntroductionFragment.S90(this.a, r7);
            return;
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ EditIntroductionFragment a;
        public final /* synthetic */ Map b;

        public g(EditIntroductionFragment r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_paidlive_activity_info_filling_page_detail_return", this.b, new Object[0]);
            EditIntroductionFragment r5 = this.a;
            EditIntroductionFragment.S90(r5, r5.i);
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ EditIntroductionFragment a;

        public h(EditIntroductionFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Fragment r3 = this.a;
            n6 r0 = r3.k;
            if (r0 == null) goto L6;
            r0.A9(r3);
            return;
        }
    }

    static {
    }

    public EditIntroductionFragment() {
        this.i = "";
        this.l = new IdentityHashMap();
        this.n = 686;
        this.o = new EditIntroductionFragment$imageGetter$1(this);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Map<String, n6> r0 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.b).remove(this);
        Bundle r1 = getArguments();
        if (r1 == null) goto L6;
        String r2 = r1.getString("upload_callback_key");
        if (r2 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter(r2, "key");
        com.bytedance.android.livesdk.chatroom.utils.s4.a.remove(r2);
        return;
    L6:
        r2 = "";
        goto L7
    }

    public static final void T90(EditIntroductionFragment r2) {
        if (r2.l.isEmpty() == false) goto L15;
        EditText r0 = r2.f;
        if (r0 == null) goto L7;
        r0.setText(r2.j);
    L7:
        EditText r3 = r2.f;
        if (r3 == null) goto L16;
        Editable r1 = r3.getText();
        if (r1 == null) goto L12;
        int r4 = r1.length();
    L13:
        r3.setSelection(r4);
        return;
    L12:
        r4 = 0;
        goto L13
    L16:
        return;
    }

    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        if (this.m == false) goto L18;
        Dialog r6 = getDialog();
        if (r6 == null) goto L19;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L20;
        View r0 = r7.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L13;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L13;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L13:
        r0.setPadding(0, 0, 0, 0);
        View r2 = r7.findViewById(2131389519);
        if (r2 == null) goto L16;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = -1;
        r2.setLayoutParams(r3);
    L16:
        WindowManager.LayoutParams r4 = r7.getAttributes();
        r4.width = -1;
        r4.height = (int) fm3.e.a(r7.getContext(), this.n);
        r7.setAttributes(r4);
        r7.setBackgroundDrawable(new ColorDrawable(0));
        r7.setGravity(80);
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        boolean r4 = r3.getBoolean("open_as_dialog_fragment");
    L6:
        this.m = r4;
        if (r4 == false) goto L14;
        Bundle r5 = getArguments();
        if (r5 == null) goto L11;
        int r6 = r5.getInt("page_height");
    L12:
        this.n = r6;
        setStyle(1, 2131954662);
        setBottomSheetSlideProcessor(new d());
        return;
    L11:
        r6 = 686;
        goto L12
    L14:
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        if (this.m == false) goto L5;
        r3.setCanceledOnTouchOutside(false);
        r3.setOnCancelListener(new e(this));
    L5:
        return r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.d0
    public final void z9(final String r3) {
        if ((getActivity() instanceof Context) == true) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L15;
        U90(r3, new EditIntroductionFragment$onUploadSuccess$1(this, r3), EditIntroductionFragment$onUploadSuccess$2.INSTANCE);
        return;
    L15:
        return;
    L9:
        r0 = false;
        goto L10
    }

    public static final void S90(EditIntroductionFragment r2, String r3) {
        n6 r0 = r2.k;
        if (r0 == null) goto L5;
        r0.B9(r3);
    L5:
        int r1 = x8.a.a;
        x8.a.d("EditIntroductionFragment", "finish edit " + r3, false);
        if (r2.m == true) goto L17;
        FragmentActivity r4 = r2.getActivity();
        if (r4 == null) goto L21;
        r4.finish();
        return;
    L21:
        return;
    L17:
        r2.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L19;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super.onViewCreated(r10, r11);
        Bundle r12 = getArguments();
        if (r12 == null) goto L7;
        String r13 = r12.getString("upload_callback_key");
        if (r13 == null) goto L7;
        Map<String, n6> r14 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(r13, "key");
        this.k = com.bytedance.android.livesdk.chatroom.utils.s4.a.remove(r13);
    L7:
        Bundle r15 = getArguments();
        String r16 = "";
        if (r15 == null) goto L13;
        String r17 = r15.getString("edit_content", "");
        if (r17 == null) goto L13;
        r16 = r17;
    L13:
        this.i = r16;
        Bundle r18 = getArguments();
        if (r18 == null) goto L16;
        boolean r19 = r18.getBoolean("add_image_directly", false);
    L17:
        if (r19 == false) goto L22;
        n6 r110 = this.k;
        if (r110 == null) goto L22;
        r110.A9(this);
    L22:
        if (this.i.length() <= 0) goto L24;
        boolean r111 = true;
    L25:
        if (r111 == false) goto L53;
        Spanned r2 = null;
        Spanned r112 = Html.fromHtml(this.i, this.o, null);
        if ((r112 instanceof SpannableStringBuilder) == false) goto L30;
        r2 = r112;
    L30:
        SpannableStringBuilder r3 = (SpannableStringBuilder) r2;
        this.j = r3;
        if (r3 == null) goto L53;
        ImageSpan[] r113 = (ImageSpan[]) r3.getSpans(0, r3.length(), ImageSpan.class);
        if (r113 == null) goto L53;
        int r1 = r113.length;
        int r4 = 0;
    L36:
        if (r4 >= r1) goto L49;
        ImageSpan r5 = r113[r4];
        String r6 = r5.getSource();
        if (r6 == null) goto L47;
        SpannableStringBuilder r7 = this.j;
        int r8 = -1;
        if (r7 == null) goto L42;
        int r9 = r7.getSpanStart(r5);
    L43:
        SpannableStringBuilder r20 = this.j;
        if (r20 == null) goto L46;
        r8 = r20.getSpanEnd(r5);
    L46:
        this.l.put(r6, new s6(r9, r8, r5));
        goto L47
    L42:
        r9 = -1;
    L47:
        r4 = r4 + 1;
        goto L36
    L49:
        if (this.l.isEmpty() == false) goto L53;
        EditText r114 = this.f;
        if (r114 == null) goto L53;
        r114.setText(this.j);
    L53:
        EditText r115 = this.f;
        if (r115 == null) goto L56;
        r115.setOnTouchListener(new c6(this));
    L56:
        Map<String, n6> r116 = com.bytedance.android.livesdk.chatroom.utils.s4.a;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) com.bytedance.android.livesdk.chatroom.utils.s4.b).add(this);
        Map r117 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_from_merge", "direct_shoot"), TuplesKt.to("live_type", "video_live")});
        View r118 = this.d;
        if (r118 == null) goto L59;
        r118.setOnClickListener(new f(this, r117));
    L59:
        View r119 = this.e;
        if (r119 == null) goto L62;
        r119.setOnClickListener(new g(this, r117));
    L62:
        View r120 = this.g;
        if (r120 == null) goto L69;
        r120.setOnClickListener(new h(this));
        return;
    L69:
        return;
    L24:
        r111 = false;
        goto L25
    L16:
        r19 = false;
        goto L17
    }

    public final void U90(String r5, Function2<? super String, ? super Drawable, Unit> r6, Function1<? super String, Unit> r7) {
        com.bytedance.android.livesdk.chatroom.utils.a1.l(new ImageModel(null, CollectionsKt.listOf(r5)), 0, 0, true, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r6, r5), new c(r7, r5));
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        n6 r0 = this.k;
        if (r0 == null) goto L5;
        r0.C9(r2, r3, r4);
    L5:
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r2, r3, r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = LayoutInflater.from(getContext()).inflate(2131566220, r3, false);
        this.h = r5;
        View r6 = null;
        if (r5 == null) goto L5;
        EditText r7 = (EditText) r5.findViewById(2131375571);
    L6:
        this.f = r7;
        View r8 = this.h;
        if (r8 == null) goto L9;
        View r9 = r8.findViewById(2131362255);
    L10:
        this.g = r9;
        View r10 = this.h;
        if (r10 == null) goto L13;
        View r11 = r10.findViewById(2131372573);
    L14:
        this.d = r11;
        View r12 = this.h;
        if (r12 == null) goto L17;
        r6 = r12.findViewById(2131371863);
    L17:
        this.e = r6;
        return this.h;
    L13:
        r11 = null;
        goto L14
    L9:
        r9 = null;
        goto L10
    L5:
        r7 = null;
        goto L6
    }
}
