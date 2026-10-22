package com.bumptech.glide.load.data;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelFileDescriptorRewinder implements e<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InternalRewinder f670a;

    private static final class InternalRewinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f671a;

        InternalRewinder(ParcelFileDescriptor r1) {
            this.f671a = r1;
        }

        ParcelFileDescriptor rewind() {
            Os.lseek(this.f671a.getFileDescriptor(), 0, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L5
            return this.f671a;
        L5:
            e = move-exception;
            throw new IOException(e);
        }
    }

    public static final class a implements e.a<ParcelFileDescriptor> {
        public a() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<ParcelFileDescriptor> a2(ParcelFileDescriptor r1) {
            return new ParcelFileDescriptorRewinder(r1);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public /* synthetic */ e<ParcelFileDescriptor> a(ParcelFileDescriptor r3) {
            return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor r2) {
        this.f670a = new InternalRewinder(r2);
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        return false;
    L5:
        if ("robolectric".equals(Build.FINGERPRINT) == true) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.data.e
    public /* synthetic */ ParcelFileDescriptor a() {
        return d();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    public ParcelFileDescriptor d() {
        return this.f670a.rewind();
    }
}
