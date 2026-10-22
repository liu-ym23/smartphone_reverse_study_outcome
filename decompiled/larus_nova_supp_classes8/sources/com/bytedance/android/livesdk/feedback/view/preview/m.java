package com.bytedance.android.livesdk.feedback.view.preview;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m implements i {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.feedback.view.preview.i
    public final void onClick(boolean r2) {
        if (r2 == false) goto L6;
        h r3 = this.a.getListener();
        if (r3 == null) goto L10;
        r3.a(this.a.getRoomCardStruct());
        return;
    L10:
        return;
    L6:
        h r4 = this.a.getListener();
        if (r4 == null) goto L12;
        r4.b(this.a.getRoomCardStruct());
        return;
    }
}
