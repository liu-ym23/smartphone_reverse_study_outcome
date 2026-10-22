package com.ss.android.lark.keyboard.biz.mention;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.widget.BottomSheet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j extends BottomSheet {
    public final Activity d;
    public b e;
    public final Lazy f;

    public static final class a {
    }

    public static final class b {
        public final View a;
        public final View b;
        public final ImageView c;
        public final TextView d;
        public final TextView e;
        public final TextView f;

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "rootView");
            this.a = r2;
            this.b = r2.findViewById(2131366983);
            this.c = (ImageView) r2.findViewById(2131363623);
            this.d = (TextView) r2.findViewById(2131388736);
            this.e = (TextView) r2.findViewById(2131388724);
            this.f = (TextView) r2.findViewById(2131367647);
        }
    }

    static {
    }

    public j(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super(r2);
        this.d = r2;
        this.f = LazyKt.lazy(FlowMentionDoubaoTip$model$2.INSTANCE);
    }

    @Override // com.ss.android.lark.keyboard.widget.BottomSheet
    public final View a(ViewGroup r11) {
        Intrinsics.checkNotNullParameter(r11, "container");
        View r12 = LayoutInflater.from(r11.getContext()).inflate(2131558735, r11, false);
        Intrinsics.checkNotNull(r12);
        b r0 = new b(r12);
        this.e = r0;
        r0.b.setOnClickListener(new k(this));
        r0.f.setOnClickListener(new l(this));
        r0.f.setText(UIUtils.getString(this.d, 2131890808));
        LifecycleOwner r1 = this.d;
        if ((r1 instanceof LifecycleOwner) == false) goto L5;
        LifecycleOwner r2 = r1;
    L6:
        if (r2 == null) goto L9;
        BuildersKt.launch$default(LifecycleKt.getCoroutineScope(r2.getLifecycle()), null, null, new FlowMentionDoubaoTip$loadDoubaoAvatarIfNeed$1(this, r0, null), 3, null);
    L9:
        return r12;
    L5:
        r2 = null;
        goto L6
    }
}
