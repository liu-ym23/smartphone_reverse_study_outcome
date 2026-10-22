package com.ss.android.token;

import android.content.Context;
import com.bytedance.sdk.account.utils.LazySerializedData;
import com.ss.android.account.k;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class TicketTrackData {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final long h;
    public final String i;

    public static final class Serialized extends LazySerializedData<TicketTrackData> {

        /* JADX INFO: renamed from: com.ss.android.token.TicketTrackData$Serialized$1, reason: invalid class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0017\u0010\u0002\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/ss/android/token/TicketTrackData;", "p1", "", "Lkotlin/ParameterName;", DBDefinition.NAME, "json", "invoke"}, k = 3, mv = {1, 1, 15})
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<String, TicketTrackData> {
            public AnonymousClass1(a r2) {
                super(1, r2);
            }

            public final String getName() {
                return "createFromJson";
            }

            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(a.class);
            }

            public final String getSignature() {
                return "createFromJson$account_sdk_core_release(Ljava/lang/String;)Lcom/ss/android/token/TicketTrackData;";
            }

            public final TicketTrackData invoke(String r15) {
                a r0 = (a) ((CallableReference) this).receiver;
                a r1 = a.a;
                if (r15 != null) goto L5;
            L8:
                boolean r2 = true;
            L10:
                if (r2 == true) goto L20;
                JSONObject r3 = new JSONObject(r15);     // Catch: Exception -> L14
                return new TicketTrackData(r3.optString("sourcePath"), r3.optString("sourceLogId"), r3.optString("teePub"), r3.optString("reePub"), r3.optString("updateAttestTsSignPath"), r3.optString("updateAttestTsSignLogId"), r3.optInt(EffectConfiguration.KEY_VERSION, 0), r3.optLong("tokenUpdateTime", 0), r3.optString("tokenUpdateAppVersion", ""));
            L14:
                e = move-exception;
                tb7.a.c("TicketTrackData", "createFromJson error", e);
                return null;
            L20:
                return null;
            L5:
                if (r15.length() == 0) goto L8;
                r2 = false;
                goto L10
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((String) r1);
            }
        }

        public Serialized(String r3) {
            super(r3, new AnonymousClass1(a.a));
        }
    }

    public static final class a {
        public static final a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L5;
    L32:
        return true;
    L5:
        if ((r8 instanceof TicketTrackData) == false) goto L31;
        TicketTrackData r9 = (TicketTrackData) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == false) goto L31;
        if (Intrinsics.areEqual(this.b, r9.b) == false) goto L31;
        if (Intrinsics.areEqual(this.c, r9.c) == false) goto L31;
        if (Intrinsics.areEqual(this.d, r9.d) == false) goto L31;
        if (Intrinsics.areEqual(this.e, r9.e) == false) goto L31;
        if (Intrinsics.areEqual(this.f, r9.f) == false) goto L31;
        if (this.g != r9.g) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == false) goto L31;
        if (this.h != r9.h) goto L26;
        boolean r2 = true;
    L27:
        if (r2 == false) goto L31;
        if (Intrinsics.areEqual(this.i, r9.i) == false) goto L31;
    L26:
        r2 = false;
        goto L27
    L21:
        r1 = false;
    L31:
        return false;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (((r15 + r17) * 31) + this.g) * 31;
        long r19 = this.h;
        int r20 = (r18 + ((int) (r19 ^ (r19 >>> 32)))) * 31;
        String r21 = this.i;
        if (r21 == null) goto L30;
        r1 = r21.hashCode();
    L30:
        return r20 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TicketTrackData(sourcePath=" + this.a + ", sourceLogId=" + this.b + ", teePub=" + this.c + ", reePub=" + this.d + ", updateAttestTsSignPath=" + this.e + ", updateAttestTsSignLogId=" + this.f + ", version=" + this.g + ", tokenUpdateTime=" + this.h + ", tokenUpdateAppVersion=" + this.i + ")";
    }

    public TicketTrackData(TicketTrackData r12, String r13, String r14) {
        this(r12.a, r12.b, r12.c, r12.d, r13, r14, 2, r12.h, r12.i);
    }

    public TicketTrackData(String r13, String r14, String r15, String r16, boolean r17) {
        if (r17 == false) goto L5;
        long r0 = System.currentTimeMillis();
    L6:
        long r9 = r0;
        if (r17 == false) goto L15;
        Context r1 = k.c();
        if (r1 == null) goto L15;
        String r2 = r1.getPackageManager().getPackageInfo(r1.getPackageName(), 0).versionName;     // Catch: Throwable -> L13
    L16:
        this(r13, r14, r15, r16, "", "", 2, r9, r2);
        return;
    L13:
        th = move-exception;
        tb7.a.f("Utils", "getClientVersionCode error", th);
    L15:
        r2 = "";
        goto L16
    L5:
        r0 = 0;
        goto L6
    }

    public TicketTrackData(String r1, String r2, String r3, String r4, String r5, String r6, int r7, long r8, String r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r10;
    }
}
