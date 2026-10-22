package com.bytedance.android.livesdk.interactivity.common.business.quickcomment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.quickcomment.IQuickCommentShowWord;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class QuickCommentView extends FrameLayout {
    public RecyclerView a;
    public b b;
    public a c;
    public boolean d;

    public interface a {
        void a(QuickCommentView r1);

        void b(IQuickCommentShowWord r1);
    }

    public static class b extends RecyclerView.Adapter<c> {
        public final List<IQuickCommentShowWord> a;
        public a b;

        public interface a {
        }

        public final int getItemCount() {
            return ((ArrayList) this.a).size();
        }

        public b() {
            this.a = new ArrayList();
            this.b = null;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            c r7 = (c) r5;
            IQuickCommentShowWord r0 = (IQuickCommentShowWord) ListProtector.get(this.a, r6);
            r7.a.setTag(r0);
            TextView r1 = r7.a;
            SpannableString r2 = new SpannableString(r0.getContent());
            ab2.a.e(r2, s1.f(16.0f));
            r1.setText(r2);
            if (TextUtils.isEmpty(r0.getBackgroundColor()) == false) goto L10;
            r7.a.setBackgroundResource(2131249781);
        L8:
            ((RecyclerView.ViewHolder) r7).itemView.setTag(2131389719, Integer.valueOf(r6));
            return;
        L10:
            int r3 = Color.parseColor(r0.getBackgroundColor());     // Catch: IllegalArgumentException -> L6
            GradientDrawable r4 = new GradientDrawable();     // Catch: IllegalArgumentException -> L6
            r4.setColor(r3);     // Catch: IllegalArgumentException -> L6
            r4.setCornerRadius(s1.f(14.0f));     // Catch: IllegalArgumentException -> L6
            r7.a.setBackground(r4);     // Catch: IllegalArgumentException -> L6
        L6:
            r7.a.setBackgroundResource(2131249781);
            goto L8
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            return new c(LayoutInflater.from(r3.getContext()).inflate(2131566378, r3, false), this.b);
        }
    }

    public static class c extends RecyclerView.ViewHolder {
        public final TextView a;

        public c(View r2, final b.a r3) {
            super(r2);
            TextView r4 = (TextView) r2.findViewById(2131367794);
            this.a = r4;
            r4.setOnClickListener(new m72.c(this, r3));
        }
    }

    public final void a() {
        LayoutInflater.from(getContext()).inflate(2131567820, this);
        RecyclerView r0 = findViewById(2131384076);
        this.a = r0;
        r0.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        b r1 = new b();
        this.b = r1;
        this.a.setAdapter(r1);
        b r2 = this.b;
        r2.b = new m72.a(this);
        setOnClickListener(new m72.b(this));
    }

    public QuickCommentView(Context r1) {
        super(r1);
        this.d = false;
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        boolean r1 = false;
        if (this.a == null) goto L13;
        if (r5.getAction() != 0) goto L13;
        if (this.a.canScrollHorizontally(-1) == false) goto L9;
    L10:
        r1 = true;
    L11:
        this.d = r1;
    L20:
        return super.dispatchTouchEvent(r5);
    L9:
        if (this.a.canScrollHorizontally(1) == false) goto L11;
    L13:
        if (r5.getAction() != 3) goto L15;
    L18:
        this.d = false;
        goto L20
    L15:
        if (r5.getAction() == 1) goto L18;
        if (this.a != null) goto L20;
        goto L18
    }

    public void setListener(a r1) {
        this.c = r1;
    }

    public void setQuickComment(List<IQuickCommentShowWord> r3) {
        b r0 = this.b;
        if (r0 == null) goto L6;
        ((ArrayList) r0.a).clear();
        ((ArrayList) r0.a).addAll(r3);
        r0.notifyDataSetChanged();
        return;
    }

    public QuickCommentView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.d = false;
        a();
    }

    public QuickCommentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.d = false;
        a();
    }
}
