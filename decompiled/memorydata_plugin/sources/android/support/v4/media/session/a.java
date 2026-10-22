package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0011a extends Binder implements a {

        /* JADX INFO: renamed from: android.support.v4.media.session.a$a$a, reason: collision with other inner class name */
        private static class C0012a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f73a;

            C0012a(IBinder r3) {
                this.f73a = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            }

            @Override // android.support.v4.media.session.a
            public void a() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                this.f73a.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f73a.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(7, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(MediaMetadataCompat r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(4, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(8, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(3, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(CharSequence r4) {
                CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r5 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                TextUtils.writeToParcel(r5, r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(6, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(String r3, Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                r0.writeString(r3);     // Catch: Throwable -> L10
                if (r4 == null) goto L6;
                r0.writeInt(1);     // Catch: Throwable -> L10
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L10
            L7:
                this.f73a.transact(1, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r0.writeInt(0);     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> r4) {
                List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                r0.writeTypedList(r5);     // Catch: Throwable -> L6
                this.f73a.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void a(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.f73a.transact(10, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f73a;
            }

            @Override // android.support.v4.media.session.a
            public void b() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                this.f73a.transact(13, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void b(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.f73a.transact(12, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");     // Catch: Throwable -> L10
                if (r4 == false) goto L6;
                int r5 = 1;
            L7:
                r0.writeInt(r5);     // Catch: Throwable -> L10
                this.f73a.transact(11, r0, null, 1);     // Catch: Throwable -> L10
                r0.recycle();
                return;
            L6:
                r5 = 0;
            L10:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public AbstractBinderC0011a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static a a(IBinder r3) {
            IBinder r4 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            if (r4 != null) goto L6;
            return null;
        L6:
            IInterface r0 = r4.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r0 == null) goto L13;
            if (ZeusTransformUtils.instanceOf(r0, a.class) == false) goto L13;
            return (a) ZeusTransformUtils.preCheckCast(r0, a.class, "com.obric.memorydata.plugin");
        L13:
            return new C0012a(r4);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r6, Parcel r7, Parcel r8, int r9) {
            if (r6 == 1598968902) goto L58;
            boolean r0 = false;
            Bundle r4 = null;
            ParcelableVolumeInfo r5 = null;
            Bundle r10 = null;
            CharSequence r11 = null;
            MediaMetadataCompat r12 = null;
            PlaybackStateCompat r13 = null;
            switch(r6) {
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L34;
                case 7: goto L29;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L17;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            b();
            return true;
        L10:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            b(r7.readInt());
            return true;
        L12:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L15;
            r0 = true;
        L15:
            b(r0);
            return true;
        L17:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L20;
            r0 = true;
        L20:
            a(r0);
            return true;
        L22:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a(r7.readInt());
            return true;
        L24:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L27;
            r5 = (ParcelableVolumeInfo) ZeusTransformUtils.preCheckCast(ParcelableVolumeInfo.CREATOR.createFromParcel(r7), ParcelableVolumeInfo.class, "com.obric.memorydata.plugin");
        L27:
            a(r5);
            return true;
        L29:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L32;
            r10 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L32:
            a(r10);
            return true;
        L34:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L37;
            r11 = (CharSequence) ZeusTransformUtils.preCheckCast(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r7), CharSequence.class, "com.obric.memorydata.plugin");
        L37:
            a(r11);
            return true;
        L39:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a(r7.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L44;
            r12 = (MediaMetadataCompat) ZeusTransformUtils.preCheckCast(MediaMetadataCompat.CREATOR.createFromParcel(r7), MediaMetadataCompat.class, "com.obric.memorydata.plugin");
        L44:
            a(r12);
            return true;
        L46:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r7.readInt() == 0) goto L49;
            r13 = (PlaybackStateCompat) ZeusTransformUtils.preCheckCast(PlaybackStateCompat.CREATOR.createFromParcel(r7), PlaybackStateCompat.class, "com.obric.memorydata.plugin");
        L49:
            a(r13);
            return true;
        L51:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            a();
            return true;
        L53:
            r7.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            String r14 = r7.readString();
            if (r7.readInt() == 0) goto L56;
            r4 = (Bundle) ZeusTransformUtils.preCheckCast(Bundle.CREATOR.createFromParcel(r7), Bundle.class, "com.obric.memorydata.plugin");
        L56:
            a(r14, r4);
            return true;
        L7:
            return super.onTransact(r6, r7, r8, r9);
        L58:
            r8.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void a();

    void a(int r1);

    void a(Bundle r1);

    void a(MediaMetadataCompat r1);

    void a(ParcelableVolumeInfo r1);

    void a(PlaybackStateCompat r1);

    void a(CharSequence r1);

    void a(String r1, Bundle r2);

    void a(List<MediaSessionCompat.QueueItem> r1);

    void a(boolean r1);

    void b();

    void b(int r1);

    void b(boolean r1);
}
