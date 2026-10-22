package com.bytedance.android.livesdk.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zw1.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\t\u0010\u0010J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/feed/ui/FeedLiveCoverInfoView;", "Landroid/widget/FrameLayout;", "Lzw1/a;", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "", "setRoomInfo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedLiveCoverInfoView extends FrameLayout implements a {
    public FrameLayout a;

    public void setRoomInfo(Room r1) {
    }

    public final void a() {
        FrameLayout.inflate(getContext(), 2131566009, this);
        RecyclerView r0 = findViewById(2131392385);
        this.a = (FrameLayout) findViewById(2131392384);
    }

    public FeedLiveCoverInfoView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        a();
    }

    public FeedLiveCoverInfoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        a();
    }

    public FeedLiveCoverInfoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        a();
    }
}
