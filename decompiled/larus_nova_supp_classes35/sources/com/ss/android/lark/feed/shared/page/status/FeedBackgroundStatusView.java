package com.ss.android.lark.feed.shared.page.status;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ,\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011H&¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", BuildConfig.FLAVOR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setStatus", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", "description", BuildConfig.FLAVOR, "onRetry", "Lkotlin/Function0;", "FeedPageStatus", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FeedBackgroundStatusView extends RelativeLayout {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/status/FeedBackgroundStatusView$FeedPageStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "HIDE", "LOADING", "EMPTY", "ERROR", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeedPageStatus extends Enum<FeedPageStatus> {
        public static final FeedPageStatus EMPTY = null;
        public static final FeedPageStatus ERROR = null;
        public static final FeedPageStatus HIDE = null;
        public static final FeedPageStatus LOADING = null;
        public static final /* synthetic */ FeedPageStatus[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<FeedPageStatus> getEntries() {
            return b;
        }

        static {
            FeedPageStatus r0 = new FeedPageStatus("HIDE", 0);
            HIDE = r0;
            FeedPageStatus r1 = new FeedPageStatus("LOADING", 1);
            LOADING = r1;
            FeedPageStatus r3 = new FeedPageStatus("EMPTY", 2);
            EMPTY = r3;
            FeedPageStatus r5 = new FeedPageStatus("ERROR", 3);
            ERROR = r5;
            FeedPageStatus[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static FeedPageStatus[] values() {
            return (FeedPageStatus[]) a.clone();
        }

        public static FeedPageStatus valueOf(String r1) {
            return (FeedPageStatus) a.a(FeedPageStatus.class, r1);
        }

        public FeedPageStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public FeedBackgroundStatusView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public FeedBackgroundStatusView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public abstract void a(FeedPageStatus r1, String r2, Function0<Unit> r3);

    public FeedBackgroundStatusView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ FeedBackgroundStatusView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
