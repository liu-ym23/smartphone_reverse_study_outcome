package com.ss.android.lark.keyboard.plugin.tool.voice.vote;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.KeyboardUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class d extends Dialog {
    public final List<String> a;
    public final osb.e b;
    public View c;
    public RecyclerView d;
    public TextView e;
    public UDButton f;
    public View g;
    public final DownVoteReasonAdapter h;
    public final DownVoteInputAdapter i;
    public final ConcatAdapter j;
    public final CoroutineScope k;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ d a;
        public final /* synthetic */ View b;

        public b(d r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            KeyboardUtils.hideKeyboard(this.a.getContext(), this.b);
        }
    }

    public static final class c implements OnApplyWindowInsetsListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ ConstraintLayout b;

        public c(View r1, ConstraintLayout r2) {
            this.a = r1;
            this.b = r2;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r3, WindowInsetsCompat r4) {
            Intrinsics.checkNotNullParameter(r3, "<unused var>");
            Intrinsics.checkNotNullParameter(r4, "insets");
            Insets r5 = r4.getInsets(WindowInsetsCompat.Type.ime());
            if (r5.bottom <= this.a.getPaddingBottom()) goto L5;
            this.b.setTranslationY(-r5.bottom);
        L6:
            return r4;
        L5:
            this.b.setTranslationY(0.0f);
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.vote.d$d, reason: collision with other inner class name */
    public static final class ViewOnLayoutChangeListenerC0164d implements View.OnLayoutChangeListener {
        public final /* synthetic */ d a;

        public ViewOnLayoutChangeListenerC0164d(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            if (r2 != r6) goto L7;
            if (r3 != r7) goto L7;
            if (r4 != r8) goto L7;
            if (r5 != r9) goto L7;
            return;
        L7:
            d r10 = this.a;
            Intrinsics.checkNotNull(r1);
            r10.b(r1);
        }
    }

    static {
    }

    public void a() {
        ArrayList r0 = new ArrayList();
        List<String> r1 = this.a;
        if (r1 == null) goto L12;
        Iterator<T> r2 = r1.iterator();
        int r3 = 0;
    L6:
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        r0.add(new DownVoteReasonAdapter.b(String.valueOf(r3), (String) r4));
        r3 = r5;
    L12:
        if ((!r0.isEmpty()) == false) goto L18;
        DownVoteReasonAdapter r6 = this.h;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "reasonList");
        ((ArrayList) r6.b).clear();
        ((ArrayList) r6.b).addAll(r0);
        r6.notifyDataSetChanged();
        return;
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        CoroutineScopeKt.cancel$default(this.k, null, 1, null);
    }

    public final void b(View r8) {
        Window r0 = getWindow();
        if (r0 == null) goto L20;
        r0.setGravity(80);
        r0.setWindowAnimations(2131952070);
        Resources r1 = r0.getContext().getResources();
        int r2 = WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).widthPixels;
        Resources r3 = r0.getContext().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).heightPixels;
        int r5 = (int) (((double) r4) * 0.9d);
        Log.d("FeedbackDialog", "screenWidth: " + r2 + ", screenHeight: " + r4 + ", maxDialogHeight: " + r5);
        r8.measure(View.MeasureSpec.makeMeasureSpec(r2, 1073741824), View.MeasureSpec.makeMeasureSpec(r4, 0));
        int r6 = r8.getMeasuredHeight();
        StringBuilder r7 = new StringBuilder("measuredHeight: ");
        r7.append(r6);
        Log.d("FeedbackDialog", r7.toString());
        if (r6 > r5) goto L7;
        r5 = r6;
    L7:
        Log.d("FeedbackDialog", "finalDialogHeight: " + r5);
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 != null) goto L10;
        r9 = new ViewGroup.LayoutParams(-1, -2);
    L10:
        r9.height = r5;
        r8.setLayoutParams(r9);
        RecyclerView r10 = this.d;
        if (r10 == null) goto L14;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if (r11 == null) goto L14;
    L15:
        RecyclerView r12 = this.d;
        if (r12 == null) goto L18;
        r12.setLayoutParams(r11);
    L18:
        r0.setLayout(-1, r5);
        return;
    L14:
        r11 = new ViewGroup.LayoutParams(-1, -2);
        goto L15
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        WindowCompat.setDecorFitsSystemWindows(r0, false);
    L5:
        UDButton r3 = null;
        View r1 = LayoutInflater.from(getContext()).inflate(2131560028, null);
        setContentView(r1);
        View r2 = findViewById(2131366972);
        if (r2 == null) goto L8;
        r2.setOnClickListener(new uob.c(this));
    L9:
        this.c = r2;
        TextView r4 = (TextView) findViewById(2131388772);
        if (r4 == null) goto L12;
        r4.setTextSize(0, zz7.b.g(r4.getContext(), 17));
    L12:
        RecyclerView r5 = findViewById(2131384076);
        if (r5 == null) goto L18;
        r5.setLayoutManager(new LinearLayoutManager(r5.getContext()));
        r5.setAdapter(this.j);
        DividerItemDecoration r6 = new DividerItemDecoration(r5.getContext(), 1);
        Drawable r7 = ResourcesCompat.getDrawable(r5.getContext().getResources(), 2131231961, r5.getContext().getTheme());
        if (r7 == null) goto L17;
        r6.setDrawable(r7);
    L17:
        r5.addItemDecoration(r6);
    L19:
        this.d = r5;
        TextView r8 = (TextView) findViewById(2131383033);
        if (r8 == null) goto L22;
        r8.setTextSize(0, zz7.b.g(r8.getContext(), 12));
    L23:
        this.e = r8;
        UDButton r9 = (UDButton) findViewById(2131387570);
        if (r9 == null) goto L26;
        r9.setTextSize(0, zz7.b.g(r9.getContext(), 17));
        r9.setEnabled(true);
        r9.setOnClickListener(new e(this, r9));
        r3 = r9;
    L26:
        this.f = r3;
        a();
        this.g = r1;
        Intrinsics.checkNotNull(r1);
        b(r1);
        r1.setOnClickListener(new b(this, r1));
        ViewCompat.setOnApplyWindowInsetsListener(r1, new c(r1, r1.findViewById(2131367812)));
        r1.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0164d(this));
        return;
    L22:
        r8 = null;
        goto L23
    L18:
        r5 = null;
        goto L19
    L8:
        r2 = null;
        goto L9
    }

    public d(Context r3, List<String> r4, osb.e r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "clickListener");
        super(r3, 2131952069);
        this.a = r4;
        this.b = r5;
        DownVoteReasonAdapter r6 = new DownVoteReasonAdapter();
        this.h = r6;
        DownVoteInputAdapter r7 = new DownVoteInputAdapter();
        this.i = r7;
        this.j = new ConcatAdapter(new RecyclerView.Adapter[]{r6, r7});
        this.k = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
