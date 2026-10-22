package com.larus.drive.sdk.impl.utils;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.larus.drive.sdk.api.file.DriveFileItem;
import hq9.c2;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class t implements v79.d {
    public final /* synthetic */ DriveFileItem a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ v79.e c;

    public static final class a implements v79.c<SimpleRequestResult> {
        public final /* synthetic */ v79.e a;
        public final /* synthetic */ DriveFileItem b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;

        @Override // v79.c
        public final void onFailure(String r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Context r0 = this.d;
            if (Intrinsics.areEqual(r3, "error_message_drive_update") == false) goto L5;
            int r4 = 2131905388;
        L6:
            String r5 = r0.getString(r4);
            t19.s r1 = t19.s.a;
            Context r2 = this.d;
            r1.getClass();
            t19.s.t(r2, r5);
            return;
        L5:
            r4 = 2131905570;
            goto L6
        }

        @Override // v79.c
        public final void onSuccess(SimpleRequestResult r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            v79.e r4 = this.a;
            if (r4 == null) goto L6;
            r4.b(this.b.b, this.c);
            return;
        }

        public a(v79.e r1, DriveFileItem r2, String r3, Context r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // v79.d
    public final void d() {
    }

    @Override // v79.d
    public final void a(String r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        StringBuilder r0 = new StringBuilder();
        r0.append(r6);
        DriveFileItem r7 = this.a;
        Parcelable.Creator<DriveFileItem> r1 = DriveFileItem.CREATOR;
        r0.append(r7.d(true));
        String r8 = r0.toString();
        Lazy r2 = MorePanelHelper.a;
        e89.c r3 = MorePanelHelper.c();
        DriveFileItem r4 = this.a;
        r3.j(r4, r8, new a(this.c, r4, r8, this.b));
    }

    @Override // v79.d
    public final boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Lazy r0 = MorePanelHelper.a;
        int r1 = ((c2) MorePanelHelper.a.getValue()).d();
        DriveFileItem r2 = this.a;
        Parcelable.Creator<DriveFileItem> r3 = DriveFileItem.CREATOR;
        int r5 = r1 - r2.d(true).length();
        if (r4.length() <= r5) goto L6;
        t19.s r6 = t19.s.a;
        Context r7 = this.b;
        r6.getClass();
        t19.s.s(r7, 2131901079);
        return false;
    L6:
        return true;
    }

    @Override // v79.d
    public final Pair<Boolean, String> c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Lazy r0 = MorePanelHelper.a;
        int r1 = ((c2) MorePanelHelper.a.getValue()).d();
        DriveFileItem r2 = this.a;
        Parcelable.Creator<DriveFileItem> r3 = DriveFileItem.CREATOR;
        int r5 = r1 - r2.d(true).length();
        if (r4.length() <= r5) goto L7;
        t19.s r6 = t19.s.a;
        Context r7 = this.b;
        r6.getClass();
        t19.s.s(r7, 2131901079);
        return TuplesKt.to(Boolean.TRUE, StringsKt.take(r4, r5));
    L7:
        return TuplesKt.to(Boolean.FALSE, r4);
    }

    public t(DriveFileItem r1, Context r2, v79.e r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
