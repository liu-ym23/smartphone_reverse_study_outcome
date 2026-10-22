package com.bytedance.android.live.search.impl.search.ui;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/SearchHeadListView;", "Landroid/widget/LinearLayout;", "", "Lpa1/c;", "listener", "", "setViewListener", "", "a", "I", "getSoftInputMode", "()I", "setSoftInputMode", "(I)V", "softInputMode", "Lpa1/c;", "getListener", "()Lpa1/c;", "setListener", "(Lpa1/c;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchHeadListView extends LinearLayout {
    public int a;
    public final List<User> b;
    public final View c;
    public final EditText d;
    public final ImageView e;

    public static final class a implements View.OnKeyListener {
        public final /* synthetic */ SearchHeadListView a;

        public a(SearchHeadListView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r3, int r4, KeyEvent r5) {
            if (r4 != 66) goto L5;
            SearchHeadListView r6 = this.a;
            r6.d.clearFocus();
            t2.a(r6.getContext(), r6.d);
            return true;
        L5:
            if (r4 == 67) goto L8;
        L18:
            return false;
        L8:
            if (r5.getAction() != 0) goto L18;
            Editable r7 = this.a.d.getText();
            if (r7 != null) goto L12;
        L15:
            boolean r8 = true;
        L16:
            if (r8 == false) goto L18;
            this.a.getListener();
            return true;
        L12:
            if (r7.length() == 0) goto L15;
            r8 = false;
            goto L16
        }
    }

    public static final class b implements View.OnTouchListener {
        public final /* synthetic */ SearchHeadListView a;
        public final /* synthetic */ Context b;

        public b(SearchHeadListView r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r3, MotionEvent r4) {
            Context r5 = this.b;
            Window r1 = null;
            if ((r5 instanceof Activity) == true) goto L5;
            r5 = null;
        L5:
            Activity r6 = (Activity) r5;
            if (r6 == null) goto L18;
            Window r7 = r6.getWindow();
            if (r7 == null) goto L18;
            if (r4 != null) goto L11;
        L13:
            boolean r8 = false;
        L14:
            if (r8 == false) goto L16;
            r1 = r7;
        L16:
            if (r1 == null) goto L18;
            this.a.getListener();
            r1.setSoftInputMode(this.a.getSoftInputMode());
            goto L18
        L11:
            if (r4.getAction() != 0) goto L13;
            r8 = true;
        L18:
            return false;
        }
    }

    public static final class c implements TextWatcher {
        public final /* synthetic */ SearchHeadListView a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
        }

        public c(SearchHeadListView r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
            if (r1 == null) goto L4;
            r1.toString();
        L4:
            this.a.getListener();
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            Intrinsics.checkNotNullParameter(r1, "s");
            if (TextUtils.isEmpty(r1) == true) goto L8;
            if (this.a.e.getVisibility() != 8) goto L8;
            this.a.e.setVisibility(0);
            return;
        L8:
            if (TextUtils.isEmpty(r1) == true) goto L10;
            return;
        L10:
            if (this.a.e.getVisibility() != 0) goto L15;
            this.a.e.setVisibility(8);
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ SearchHeadListView a;

        public d(SearchHeadListView r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.d.setText("");
        }
    }

    public SearchHeadListView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchHeadListView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final pa1.c getListener() {
        return null;
    }

    public final void setListener(pa1.c r1) {
    }

    public void setViewListener(pa1.c r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    public final int getSoftInputMode() {
        return this.a;
    }

    public final void setSoftInputMode(int r1) {
        this.a = r1;
    }

    public SearchHeadListView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        this.a = 48;
        ArrayList r10 = new ArrayList();
        this.b = r10;
        View r12 = View.inflate(r7, 2131567427, this);
        this.c = r12;
        RecyclerView r0 = r12.findViewById(2131392027);
        ImageView r1 = (ImageView) r12.findViewById(2131376580);
        EditText r2 = (EditText) r12.findViewById(2131385429);
        this.d = r2;
        ImageView r13 = (ImageView) r12.findViewById(2131364676);
        this.e = r13;
        SearchHeadListAdapter r3 = new SearchHeadListAdapter((LifecycleOwner) r7, r10, new SearchHeadListView$mAdapter$1(this));
        int r14 = UIUtils.getScreenWidth(r7) - ((int) UIUtils.dip2Px(r7, 110.0f));
        r1.setImageResource(2131251471);
        FixedSizeLinearLayoutManager r4 = new FixedSizeLinearLayoutManager(r7);
        r4.a = r14;
        Unit r15 = Unit.INSTANCE;
        r0.setLayoutManager(r4);
        r0.setAdapter(r3);
        r0.setHorizontalScrollBarEnabled(true);
        r0.setNestedScrollingEnabled(false);
        r0.setScrollBarStyle(33554432);
        r2.setOnKeyListener(new a(this));
        r2.setOnTouchListener(new b(this, r7));
        r2.addTextChangedListener(new c(this));
        r13.setOnClickListener(new d(this));
    }

    public /* synthetic */ SearchHeadListView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
