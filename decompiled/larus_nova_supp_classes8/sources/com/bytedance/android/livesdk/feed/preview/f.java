package com.bytedance.android.livesdk.feed.preview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements qw1.a {
    public boolean a;
    public final /* synthetic */ LiveFeedPreview b;

    @Override // qw1.a
    public final void b() {
        this.a = false;
        LiveFeedPreview r0 = this.b;
        int r1 = LiveFeedPreview.h;
        r0.e(null);
    }

    @Override // qw1.a
    public final void onRoomFinished() {
        this.a = false;
        LiveFeedPreview r0 = this.b;
        int r1 = LiveFeedPreview.h;
        r0.e(null);
    }

    @Override // qw1.a
    public final void onUserNotInRoom() {
        this.a = false;
        LiveFeedPreview r0 = this.b;
        int r1 = LiveFeedPreview.h;
        r0.e(null);
    }

    @Override // qw1.a
    public final boolean onPingCheck() {
        if (this.a == false) goto L9;
        LiveFeedPreview r0 = this.b;
        if (r0.b == false) goto L9;
        if (r0.e == false) goto L9;
        return true;
    L9:
        return false;
    }

    public f(LiveFeedPreview r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // qw1.a
    public final void a(long r2) {
        this.a = false;
        LiveFeedPreview r0 = this.b;
        Integer r3 = Integer.valueOf((int) r2);
        int r4 = LiveFeedPreview.h;
        r0.e(r3);
    }
}
