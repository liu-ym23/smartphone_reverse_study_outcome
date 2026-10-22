package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/LandscapeTopMoreHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTopMoreHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final ImageView b;
    public final View c;
    public final TextView d;
    public final Context e;
    public final com.bytedance.android.livesdk.utils.z1 f;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.e;
    }

    public LandscapeTopMoreHolder(View r2, Context r3, com.bytedance.android.livesdk.utils.z1 r4) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "disposer");
        super(r2);
        this.e = r3;
        this.f = r4;
        this.a = (TextView) r2.findViewById(2131380593);
        this.b = (ImageView) r2.findViewById(2131384095);
        this.c = r2.findViewById(2131374718);
        this.d = (TextView) r2.findViewById(2131374747);
    }
}
