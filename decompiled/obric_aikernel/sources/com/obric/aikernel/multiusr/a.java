package com.obric.aikernel.multiusr;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Binder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4723c;

    /* JADX INFO: renamed from: com.obric.aikernel.multiusr.a$a, reason: collision with other inner class name */
    public static final class C0108a {
        private C0108a() {
        }

        public /* synthetic */ C0108a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IBinder f4724a;

        public b(IBinder r10) {
            Intrinsics.checkNotNullParameter(r10, "remote");
            this.f4724a = r10;
        }

        public final ParcelFileDescriptor a(String r10) {
            Intrinsics.checkNotNullParameter(r10, "url");
            Parcel r11 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r11, "obtain()");
            Parcel r12 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(r12, "obtain()");
            Parcelable r13 = null;
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L8
            r11.writeInterfaceToken("com.obric.aikernel.multiusr.MultiUsrConvertor");     // Catch: Throwable -> L8
            r11.writeString(r10);     // Catch: Throwable -> L8
            if (this.f4724a.transact(2, r11, r12, 0) == false) goto L6;
            r12.readException();     // Catch: Throwable -> L8
            r13 = r12.readParcelable(b.class.getClassLoader());     // Catch: Throwable -> L8
        L6:
            Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        L10:
            r11.recycle();
            r12.recycle();
            return (ParcelFileDescriptor) r13;
        L8:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.m32constructorimpl(ResultKt.createFailure(th));
            goto L10
        }

        public final boolean b() {
            return this.f4724a.pingBinder();
        }
    }

    static {
        new C0108a(null);
    }

    public a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super("com.obric.aikernel.multiusr.MultiUsrConvertor");
        this.f4723c = r10;
    }

    public final ParcelFileDescriptor a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        return this.f4723c.getContentResolver().openFileDescriptor(Uri.parse(r10), "r");
    }

    @Override // android.os.Binder
    protected boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        Intrinsics.checkNotNullParameter(r11, "data");
        if (r10 != 2) goto L25;
        r11.enforceInterface("com.obric.aikernel.multiusr.MultiUsrConvertor");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L10
        String r15 = r11.readString();     // Catch: Throwable -> L10
        if (r15 == null) goto L9;
        Intrinsics.checkNotNullExpressionValue(r15, "requireNotNull(data.readString())");     // Catch: Throwable -> L10
        Object r16 = Result.m32constructorimpl(a(r15));     // Catch: Throwable -> L10
    L13:
        if (Result.m39isSuccessimpl(r16) == false) goto L19;
        ParcelFileDescriptor r17 = (ParcelFileDescriptor) r16;
        if (r12 == null) goto L17;
        r12.writeNoException();
    L17:
        if (r12 == null) goto L19;
        r12.writeParcelable(r17, 0);
    L19:
        Throwable r18 = Result.m35exceptionOrNullimpl(r16);
        if (r18 == null) goto L23;
        if (r12 == null) goto L23;
        r12.writeException(new RuntimeException(r18));
    L23:
        return true;
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L13
    L25:
        return super.onTransact(r10, r11, r12, r13);
    }
}
