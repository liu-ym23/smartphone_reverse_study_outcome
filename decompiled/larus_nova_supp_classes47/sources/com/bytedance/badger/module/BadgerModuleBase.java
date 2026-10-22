package com.bytedance.badger.module;

import android.content.Context;
import com.bytedance.android.live.profile.ui.component.model.ProfileButtonType;
import com.bytedance.android.live.saas.middleware.fresco.DefaultConfig;
import com.bytedance.badger.Badger;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.badger.data.BadgerResult;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class BadgerModuleBase {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/badger/module/BadgerModuleBase$BadgerRequestData;", "", Constants.OperatorKey.KEY_TOKEN, "", "(J)V", "getToken", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, ProfileButtonType.FANS_GROUP_CREATE})
    public static final class BadgerRequestData {
        private final long token;

        public static /* synthetic */ BadgerRequestData copy$default(BadgerRequestData r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.token;
        L6:
            return r0.copy(r1);
        }

        public final long component1() {
            return this.token;
        }

        public final BadgerRequestData copy(long r2) {
            return new BadgerRequestData(r2);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L5;
        L13:
            return true;
        L5:
            if ((r8 instanceof BadgerRequestData) == true) goto L7;
        L12:
            return false;
        L7:
            if (this.token != ((BadgerRequestData) r8).token) goto L9;
            boolean r9 = true;
        L10:
            if (r9 == false) goto L12;
        L9:
            r9 = false;
            goto L10
        }

        public int hashCode() {
            long r0 = this.token;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public String toString() {
            return "BadgerRequestData(token=" + this.token + ")";
        }

        public final long getToken() {
            return this.token;
        }

        public BadgerRequestData(long r1) {
            this.token = r1;
        }
    }

    public BadgerModuleBase() {
    }

    public abstract BadgerResult a(Context r1, BadgerRequestData r2);

    public final BadgerResult execute(String r13, long r14) {
        System.nanoTime();
        Context r0 = Badger.INSTANCE.getContext();
        return a(r0, new BadgerRequestData(r14));
    L5:
        th = move-exception;
        Badger.INSTANCE.log(6, "BadgerModuleBase", "execute error", th);     // Catch: Throwable -> L8
    L9:
        StringBuilder r15 = new StringBuilder();
        r15.append(th.getClass().getName());
        r15.append(": ");
        String r1 = th.getMessage();
        if (r1 == null) goto L18;
        String r6 = StringsKt.replace$default(r1, "\n", " ", false, 4, null);
        if (r6 == null) goto L18;
        String r16 = StringsKt.replace$default(r6, "\"", "'", false, 4, null);
        if (r16 == null) goto L18;
        if (r16.length() <= 256) goto L19;
        r16 = r16.substring(0, DefaultConfig.MAX_CACHE_ENTRIES);
    L19:
        r15.append(r16);
        return new BadgerResult.Failure(BadgerResult.ERROR, r15.toString());
    L18:
        r16 = null;
        goto L19
    }
}
