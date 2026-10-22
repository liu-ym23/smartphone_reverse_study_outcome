package com.bytedance.android.live.revlink.impl.pk.dialog.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/live/revlink/impl/pk/dialog/fragment/PKRivalsPanelSearchWidget$mTextChangeListener$2$a", "invoke", "()Lcom/bytedance/android/live/revlink/impl/pk/dialog/fragment/PKRivalsPanelSearchWidget$mTextChangeListener$2$a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PKRivalsPanelSearchWidget$mTextChangeListener$2 extends Lambda implements Function0<a> {
    final /* synthetic */ PKRivalsPanelSearchWidget this$0;

    public static final class a implements TextWatcher {
        public final /* synthetic */ PKRivalsPanelSearchWidget$mTextChangeListener$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.dialog.fragment.PKRivalsPanelSearchWidget$mTextChangeListener$2$a$a, reason: collision with other inner class name */
        public static final class C0156a<T> implements Consumer {
            public final /* synthetic */ a a;

            public C0156a(a r1) {
                this.a = r1;
            }

            public final void accept(Object r4) {
                ExtraResponse r5 = (ExtraResponse) r4;
                ((ArrayList) this.a.a.this$0.n).clear();
                if (r5 == null) goto L7;
                List r1 = (List) r5.data;
                if (r1 == null) goto L7;
                int r2 = r1.size();
            L8:
                if (r2 <= 0) goto L36;
                if (r5 == null) goto L15;
                List r6 = (List) r5.data;
                if (r6 == null) goto L15;
                e21.f r7 = (e21.f) ListProtector.get(r6, 0);
                if (r7 == null) goto L15;
                List<e21.g> r8 = r7.a();
            L16:
                Intrinsics.checkNotNull(r8);
                Iterator<e21.g> r9 = r8.iterator();
            L18:
                if (r9.hasNext() == false) goto L26;
                e21.g r3 = r9.next();
                List<String> r10 = this.a.a.this$0.n;
                if (r10 == null) goto L18;
                if (r3 == null) goto L24;
                String r12 = r3.a();
                if (r12 == null) goto L24;
            L25:
                ((ArrayList) r10).add(r12);
            L24:
                r12 = "";
                goto L25
            L26:
                PKRivalsPanelSearchWidget r13 = this.a.a.this$0;
                if (r13.a == true) goto L29;
                PKRivalsPanelSearchWidget.yq(r13, 2, r13.n);
            L29:
                this.a.a.this$0.a = false;
                return;
            L15:
                r8 = null;
                goto L16
            L36:
                return;
            L7:
                r2 = 0;
                goto L8
            }
        }

        public static final class b<T> implements Consumer {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r1) {
                ((Throwable) r1).printStackTrace();
            }
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(PKRivalsPanelSearchWidget$mTextChangeListener$2 r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r5) {
            EditText r0 = this.a.this$0.c;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchEt");
        L6:
            if (r0.getText().length() <= 0) goto L8;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L24;
            ImageView r2 = this.a.this$0.d;
            if (r2 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mClearBt");
        L14:
            r2.setVisibility(0);
            this.a.this$0.Bq();
            View r3 = this.a.this$0.g;
            if (r3 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBaseView");
        L17:
            r3.setVisibility(8);
            PKRivalsPanelSearchWidget r4 = this.a.this$0;
            Observable r6 = r31.b.a(r31.a.a).P(String.valueOf(r5));
            if (r6 == null) goto L22;
            Observable r7 = r6.observeOn(AndroidSchedulers.mainThread());
            if (r7 == null) goto L22;
            Disposable r8 = r7.subscribe(new C0156a(this), b.a);
        L23:
            r4.o = r8;
            return;
        L22:
            r8 = null;
            goto L23
        L24:
            ImageView r9 = this.a.this$0.d;
            if (r9 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("mClearBt");
        L27:
            r9.setVisibility(8);
            this.a.this$0.Aq();
            this.a.this$0.r.h();
            return;
        L8:
            r1 = false;
            goto L10
        }
    }

    public PKRivalsPanelSearchWidget$mTextChangeListener$2(PKRivalsPanelSearchWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m767invoke() {
        return invoke();
    }
}
