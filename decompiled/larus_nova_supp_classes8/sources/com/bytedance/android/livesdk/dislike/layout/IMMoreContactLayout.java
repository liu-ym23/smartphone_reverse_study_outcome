package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.dislike.action.OptionAction;
import com.bytedance.android.livesdk.dislike.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMMoreContactLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/dislike/u;", "item", "", "update", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMMoreContactLayout extends FrameLayout {
    public final IMMoreContactDescItemLayout a;
    public OptionAction b;
    public final View c;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ IMMoreContactLayout a;

        public a(IMMoreContactLayout r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            OptionAction r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }
    }

    public IMMoreContactLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = View.inflate(getContext(), 2131565628, this);
        this.a = (IMMoreContactDescItemLayout) findViewById(2131368830);
        setOnClickListener(new a(this));
    }

    public final void update(u r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        this.b = r2.b;
        this.a.update(r2.c);
    }

    public IMMoreContactLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = View.inflate(getContext(), 2131565628, this);
        this.a = (IMMoreContactDescItemLayout) findViewById(2131368830);
        setOnClickListener(new a(this));
    }

    public IMMoreContactLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = View.inflate(getContext(), 2131565628, this);
        this.a = (IMMoreContactDescItemLayout) findViewById(2131368830);
        setOnClickListener(new a(this));
    }
}
