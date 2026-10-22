package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* JADX INFO: renamed from: android.support.v4.media.session.b$a$a, reason: collision with other inner class name */
        private static class C0013a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f74a;

            C0013a(IBinder r3) {
                this.f74a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.support.v4.media.session.b
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f74a.transact(44, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(int r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f74a.transact(11, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(long r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.f74a.transact(17, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(Uri r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.f74a.transact(36, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(MediaDescriptionCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(41, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(MediaDescriptionCompat r5, int r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                r0.writeInt(r6);     // Catch: Throwable -> L10
                this.f74a.transact(42, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(RatingCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(25, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(RatingCompat r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.f74a.transact(51, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(android.support.v4.media.session.a r4) {
                android.support.v4.media.session.a r5 = (android.support.v4.media.session.a) ZeusTransformUtils.wrapperContextForParams(r4, android.support.v4.media.session.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                this.f74a.transact(3, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(34, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(String r4, Bundle r5, MediaSessionCompat.ResultReceiverWrapper r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                r0.writeString(r4);     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.f74a.transact(1, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void a(boolean r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.f74a.transact(46, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public boolean a() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L8
                boolean r3 = false;
                this.f74a.transact(5, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public boolean a(KeyEvent r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                boolean r2 = true;
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                this.f74a.transact(2, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                if (r1.readInt() != 0) goto L11;
                r2 = false;
            L11:
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74a;
            }

            @Override // android.support.v4.media.session.b
            public String b() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(6, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f74a.transact(39, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(int r4, int r5, String r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                r0.writeInt(r5);     // Catch: Throwable -> L6
                r0.writeString(r6);     // Catch: Throwable -> L6
                this.f74a.transact(12, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(long r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeLong(r4);     // Catch: Throwable -> L6
                this.f74a.transact(24, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(Uri r5, Bundle r6) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L13
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L7:
                if (r6 == null) goto L9;
                r0.writeInt(1);     // Catch: Throwable -> L13
                r6.writeToParcel(r0, 0);     // Catch: Throwable -> L13
            L10:
                this.f74a.transact(16, r0, r1, 0);     // Catch: Throwable -> L13
                r1.readException();     // Catch: Throwable -> L13
                r1.recycle();
                r0.recycle();
                return;
            L9:
                r0.writeInt(0);     // Catch: Throwable -> L13
                goto L10
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(MediaDescriptionCompat r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(43, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(android.support.v4.media.session.a r4) {
                android.support.v4.media.session.a r5 = (android.support.v4.media.session.a) ZeusTransformUtils.wrapperContextForParams(r4, android.support.v4.media.session.a.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                IBinder r6 = r5.asBinder();     // Catch: Throwable -> L10
            L7:
                r0.writeStrongBinder(r6);     // Catch: Throwable -> L10
                this.f74a.transact(4, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r6 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(35, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void b(boolean r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.f74a.transact(40, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public String c() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(7, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                String r4 = r1.readString();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void c(int r4) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f74a.transact(48, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void c(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(14, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent d() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(8, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PendingIntent r4 = (PendingIntent) ZeusTransformUtils.preCheckCast(PendingIntent.CREATOR.createFromParcel(r1), PendingIntent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void d(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(15, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public long e() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(9, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                long r2 = r1.readLong();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r2;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void e(String r4, Bundle r5) {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                r0.writeString(r4);     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r5.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f74a.transact(26, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                r1.recycle();
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo f() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(10, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                ParcelableVolumeInfo r4 = (ParcelableVolumeInfo) ZeusTransformUtils.preCheckCast(ParcelableVolumeInfo.CREATOR.createFromParcel(r1), ParcelableVolumeInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat g() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(27, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                MediaMetadataCompat r4 = (MediaMetadataCompat) ZeusTransformUtils.preCheckCast(MediaMetadataCompat.CREATOR.createFromParcel(r1), MediaMetadataCompat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat h() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(28, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                PlaybackStateCompat r4 = (PlaybackStateCompat) ZeusTransformUtils.preCheckCast(PlaybackStateCompat.CREATOR.createFromParcel(r1), PlaybackStateCompat.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public List<MediaSessionCompat.QueueItem> i() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(29, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                ArrayList r4 = r1.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public CharSequence j() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(30, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r1), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public Bundle k() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L10
                this.f74a.transact(31, r0, r1, 0);     // Catch: Throwable -> L10
                r1.readException();     // Catch: Throwable -> L10
                if (r1.readInt() == 0) goto L7;
                Bundle r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r1), Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            L8:
                r1.recycle();
                r0.recycle();
                return r4;
            L7:
                r4 = null;
            L10:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public int l() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(32, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public boolean m() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L8
                boolean r3 = false;
                this.f74a.transact(45, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public int n() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(37, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public boolean o() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L8
                boolean r3 = false;
                this.f74a.transact(38, r0, r1, 0);     // Catch: Throwable -> L8
                r1.readException();     // Catch: Throwable -> L8
                if (r1.readInt() == 0) goto L6;
                r3 = true;
            L6:
                r1.recycle();
                r0.recycle();
                return r3;
            L8:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public int p() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(47, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                int r4 = r1.readInt();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return r4;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void q() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(33, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void r() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(13, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void s() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(18, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void t() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(19, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void u() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(20, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void v() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(21, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void w() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(22, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.b
            public void x() {
                Parcel r0 = Parcel.obtain();
                Parcel r1 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");     // Catch: Throwable -> L6
                this.f74a.transact(23, r0, r1, 0);     // Catch: Throwable -> L6
                r1.readException();     // Catch: Throwable -> L6
                r1.recycle();
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r1.recycle();
                r0.recycle();
                throw th;
            }
        }

        public static b a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L13;
            return (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin");
        L13:
            return new C0013a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            Bundle r2 = null;
            MediaDescriptionCompat r3 = null;
            MediaDescriptionCompat r4 = null;
            MediaDescriptionCompat r5 = null;
            Bundle r10 = null;
            Bundle r11 = null;
            Bundle r12 = null;
            Bundle r13 = null;
            RatingCompat r14 = null;
            Bundle r15 = null;
            Bundle r16 = null;
            Bundle r17 = null;
            KeyEvent r18 = null;
            MediaSessionCompat.ResultReceiverWrapper r19 = null;
            if (r6 != 51) goto L5;
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L186;
            RatingCompat r20 = (RatingCompat) ZeusTransformUtils.preCheckCast(RatingCompat.CREATOR.createFromParcel(r7), RatingCompat.class, "com.obric.memorydata.plugin");
        L188:
            if (r7.readInt() == 0) goto L190;
            r2 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L190:
            a(r20, r2);
            r8.writeNoException();
            return true;
        L186:
            r20 = null;
            goto L188
        L5:
            if (r6 == 1598968902) goto L181;
            boolean r0 = false;
            switch(r6) {
                case 1: goto L172;
                case 2: goto L167;
                case 3: goto L165;
                case 4: goto L163;
                case 5: goto L161;
                case 6: goto L159;
                case 7: goto L157;
                case 8: goto L152;
                case 9: goto L150;
                case 10: goto L145;
                case 11: goto L143;
                case 12: goto L141;
                case 13: goto L139;
                case 14: goto L134;
                case 15: goto L129;
                case 16: goto L120;
                case 17: goto L118;
                case 18: goto L116;
                case 19: goto L114;
                case 20: goto L112;
                case 21: goto L110;
                case 22: goto L108;
                case 23: goto L106;
                case 24: goto L104;
                case 25: goto L99;
                case 26: goto L94;
                case 27: goto L89;
                case 28: goto L84;
                case 29: goto L82;
                case 30: goto L77;
                case 31: goto L72;
                case 32: goto L70;
                case 33: goto L68;
                case 34: goto L63;
                case 35: goto L58;
                case 36: goto L49;
                case 37: goto L47;
                case 38: goto L45;
                case 39: goto L43;
                case 40: goto L38;
                case 41: goto L33;
                case 42: goto L28;
                case 43: goto L23;
                case 44: goto L21;
                case 45: goto L19;
                case 46: goto L14;
                case 47: goto L12;
                case 48: goto L10;
                default: goto L9;
            };
        L10:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            c(r7.readInt());
            r8.writeNoException();
            return true;
        L12:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r21 = p();
            r8.writeNoException();
            r8.writeInt(r21);
            return true;
        L14:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L17;
            r0 = true;
        L17:
            a(r0);
            r8.writeNoException();
            return true;
        L19:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean r22 = m();
            r8.writeNoException();
            r8.writeInt(r22 ? 1 : 0);
            return true;
        L21:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            a(r7.readInt());
            r8.writeNoException();
            return true;
        L23:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L26;
            r3 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.memorydata.plugin");
        L26:
            b(r3);
            r8.writeNoException();
            return true;
        L28:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L31;
            r4 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.memorydata.plugin");
        L31:
            a(r4, r7.readInt());
            r8.writeNoException();
            return true;
        L33:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L36;
            r5 = (MediaDescriptionCompat) ZeusTransformUtils.preCheckCast(MediaDescriptionCompat.CREATOR.createFromParcel(r7), MediaDescriptionCompat.class, "com.obric.memorydata.plugin");
        L36:
            a(r5);
            r8.writeNoException();
            return true;
        L38:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L41;
            r0 = true;
        L41:
            b(r0);
            r8.writeNoException();
            return true;
        L43:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            b(r7.readInt());
            r8.writeNoException();
            return true;
        L45:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean r23 = o();
            r8.writeNoException();
            r8.writeInt(r23 ? 1 : 0);
            return true;
        L47:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r24 = n();
            r8.writeNoException();
            r8.writeInt(r24);
            return true;
        L49:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L52;
            Uri r25 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r7), Uri.class, "com.obric.memorydata.plugin");
        L54:
            if (r7.readInt() == 0) goto L56;
            r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L56:
            a(r25, r10);
            r8.writeNoException();
            return true;
        L52:
            r25 = null;
            goto L54
        L58:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r26 = r7.readString();
            if (r7.readInt() == 0) goto L61;
            r11 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L61:
            b(r26, r11);
            r8.writeNoException();
            return true;
        L63:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r27 = r7.readString();
            if (r7.readInt() == 0) goto L66;
            r12 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L66:
            a(r27, r12);
            r8.writeNoException();
            return true;
        L68:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            q();
            r8.writeNoException();
            return true;
        L70:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            int r28 = l();
            r8.writeNoException();
            r8.writeInt(r28);
            return true;
        L72:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            Bundle r29 = k();
            r8.writeNoException();
            if (r29 == null) goto L75;
            r8.writeInt(1);
            r29.writeToParcel(r8, 1);
        L76:
            return true;
        L75:
            r8.writeInt(0);
            goto L76
        L77:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            CharSequence r30 = j();
            r8.writeNoException();
            if (r30 == null) goto L80;
            r8.writeInt(1);
            TextUtils.writeToParcel(r30, r8, 1);
        L81:
            return true;
        L80:
            r8.writeInt(0);
            goto L81
        L82:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            List<MediaSessionCompat.QueueItem> r31 = i();
            r8.writeNoException();
            r8.writeTypedList(r31);
            return true;
        L84:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            PlaybackStateCompat r32 = h();
            r8.writeNoException();
            if (r32 == null) goto L87;
            r8.writeInt(1);
            r32.writeToParcel(r8, 1);
        L88:
            return true;
        L87:
            r8.writeInt(0);
            goto L88
        L89:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            MediaMetadataCompat r33 = g();
            r8.writeNoException();
            if (r33 == null) goto L92;
            r8.writeInt(1);
            r33.writeToParcel(r8, 1);
        L93:
            return true;
        L92:
            r8.writeInt(0);
            goto L93
        L94:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r34 = r7.readString();
            if (r7.readInt() == 0) goto L97;
            r13 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L97:
            e(r34, r13);
            r8.writeNoException();
            return true;
        L99:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L102;
            r14 = (RatingCompat) ZeusTransformUtils.preCheckCast(RatingCompat.CREATOR.createFromParcel(r7), RatingCompat.class, "com.obric.memorydata.plugin");
        L102:
            a(r14);
            r8.writeNoException();
            return true;
        L104:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            b(r7.readLong());
            r8.writeNoException();
            return true;
        L106:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            x();
            r8.writeNoException();
            return true;
        L108:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            w();
            r8.writeNoException();
            return true;
        L110:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            v();
            r8.writeNoException();
            return true;
        L112:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            u();
            r8.writeNoException();
            return true;
        L114:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            t();
            r8.writeNoException();
            return true;
        L116:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            s();
            r8.writeNoException();
            return true;
        L118:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            a(r7.readLong());
            r8.writeNoException();
            return true;
        L120:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L123;
            Uri r35 = (Uri) ZeusTransformUtils.preCheckCast(Uri.CREATOR.createFromParcel(r7), Uri.class, "com.obric.memorydata.plugin");
        L125:
            if (r7.readInt() == 0) goto L127;
            r15 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L127:
            b(r35, r15);
            r8.writeNoException();
            return true;
        L123:
            r35 = null;
            goto L125
        L129:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r36 = r7.readString();
            if (r7.readInt() == 0) goto L132;
            r16 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L132:
            d(r36, r16);
            r8.writeNoException();
            return true;
        L134:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r37 = r7.readString();
            if (r7.readInt() == 0) goto L137;
            r17 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L137:
            c(r37, r17);
            r8.writeNoException();
            return true;
        L139:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            r();
            r8.writeNoException();
            return true;
        L141:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            b(r7.readInt(), r7.readInt(), r7.readString());
            r8.writeNoException();
            return true;
        L143:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            a(r7.readInt(), r7.readInt(), r7.readString());
            r8.writeNoException();
            return true;
        L145:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            ParcelableVolumeInfo r38 = f();
            r8.writeNoException();
            if (r38 == null) goto L148;
            r8.writeInt(1);
            r38.writeToParcel(r8, 1);
        L149:
            return true;
        L148:
            r8.writeInt(0);
            goto L149
        L150:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            long r39 = e();
            r8.writeNoException();
            r8.writeLong(r39);
            return true;
        L152:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            PendingIntent r40 = d();
            r8.writeNoException();
            if (r40 == null) goto L155;
            r8.writeInt(1);
            r40.writeToParcel(r8, 1);
        L156:
            return true;
        L155:
            r8.writeInt(0);
            goto L156
        L157:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r41 = c();
            r8.writeNoException();
            r8.writeString(r41);
            return true;
        L159:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r42 = b();
            r8.writeNoException();
            r8.writeString(r42);
            return true;
        L161:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            boolean r43 = a();
            r8.writeNoException();
            r8.writeInt(r43 ? 1 : 0);
            return true;
        L163:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            b(android.support.v4.media.session.a.AbstractBinderC0011a.a(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L165:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            a(android.support.v4.media.session.a.AbstractBinderC0011a.a(r7.readStrongBinder()));
            r8.writeNoException();
            return true;
        L167:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            if (r7.readInt() == 0) goto L170;
            r18 = (KeyEvent) ZeusTransformUtils.preCheckCast(KeyEvent.CREATOR.createFromParcel(r7), KeyEvent.class, "com.obric.memorydata.plugin");
        L170:
            boolean r44 = a(r18);
            r8.writeNoException();
            r8.writeInt(r44 ? 1 : 0);
            return true;
        L172:
            r7.enforceInterface("android.support.v4.media.session.IMediaSession");
            String r45 = r7.readString();
            if (r7.readInt() == 0) goto L175;
            Bundle r46 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L177:
            if (r7.readInt() == 0) goto L179;
            r19 = (MediaSessionCompat.ResultReceiverWrapper) ZeusTransformUtils.preCheckCast(MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(r7), MediaSessionCompat.ResultReceiverWrapper.class, "com.obric.memorydata.plugin");
        L179:
            a(r45, r46, r19);
            r8.writeNoException();
            return true;
        L175:
            r46 = null;
            goto L177
        L9:
            return super.onTransact(r6, r7, r8, r9);
        L181:
            r8.writeString("android.support.v4.media.session.IMediaSession");
            return true;
        }
    }

    void a(int r1);

    void a(int r1, int r2, String r3);

    void a(long r1);

    void a(Uri r1, Bundle r2);

    void a(MediaDescriptionCompat r1);

    void a(MediaDescriptionCompat r1, int r2);

    void a(RatingCompat r1);

    void a(RatingCompat r1, Bundle r2);

    void a(android.support.v4.media.session.a r1);

    void a(String r1, Bundle r2);

    void a(String r1, Bundle r2, MediaSessionCompat.ResultReceiverWrapper r3);

    void a(boolean r1);

    boolean a();

    boolean a(KeyEvent r1);

    String b();

    void b(int r1);

    void b(int r1, int r2, String r3);

    void b(long r1);

    void b(Uri r1, Bundle r2);

    void b(MediaDescriptionCompat r1);

    void b(android.support.v4.media.session.a r1);

    void b(String r1, Bundle r2);

    void b(boolean r1);

    String c();

    void c(int r1);

    void c(String r1, Bundle r2);

    PendingIntent d();

    void d(String r1, Bundle r2);

    long e();

    void e(String r1, Bundle r2);

    ParcelableVolumeInfo f();

    MediaMetadataCompat g();

    PlaybackStateCompat h();

    List<MediaSessionCompat.QueueItem> i();

    CharSequence j();

    Bundle k();

    int l();

    boolean m();

    int n();

    boolean o();

    int p();

    void q();

    void r();

    void s();

    void t();

    void u();

    void v();

    void w();

    void x();
}
