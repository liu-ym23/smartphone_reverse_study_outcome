package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessAidlCallback;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.IndependentDownloadBinder;
import com.ss.android.socialbase.downloader.impls.ProcessDownloadHandler;
import com.ss.android.socialbase.downloader.model.DownloadAidlTask;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.IPCUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadAidlService extends IInterface {

    public static abstract class Stub extends Binder implements IDownloadAidlService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f15570a = 0;

        public static class Proxy implements IDownloadAidlService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final IBinder f15571a;

            public Proxy(IBinder r5) {
                this.f15571a = r5;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a(DownloadAidlTask r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r12 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L6
                if (this.f15571a.transact(1, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f15571a;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void b(int r5, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                if (this.f15571a.transact(2, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void c(int r5, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(1);     // Catch: Throwable -> L6
                if (this.f15571a.transact(3, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final boolean d(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15571a.transact(36, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final boolean f(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15571a.transact(10, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void g(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(6, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final int i(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(33, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                int r13 = r11.readInt();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return r13;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void p(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(30, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final DownloadInfo a(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(11, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L12;
                DownloadInfo r13 = DownloadInfo.CREATOR.createFromParcel(r11);     // Catch: Throwable -> L6
            L13:
                r11.recycle();
                r10.recycle();
                return r13;
            L12:
                r13 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void b() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                if (this.f15571a.transact(7, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void c(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(38, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void b(ArrayList r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeStringList(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(21, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a(ArrayList r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeStringList(r5);     // Catch: Throwable -> L6
                if (this.f15571a.transact(20, r10, r11, 0) == true) goto L8;
                int r12 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void b(int r5, int r10, IDownloadAidlListener r11, int r12, boolean r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r14.writeInt(r5);     // Catch: Throwable -> L6
                r14.writeInt(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IDownloadAidlListener.Stub r16 = (IDownloadAidlListener.Stub) r11;     // Catch: Throwable -> L6
            L9:
                r14.writeStrongBinder(r16);     // Catch: Throwable -> L6
                r14.writeInt(r12);     // Catch: Throwable -> L6
                r14.writeInt(0);     // Catch: Throwable -> L6
                if (this.f15571a.transact(25, r14, r15, 0) == true) goto L12;
                int r17 = Stub.f15570a;     // Catch: Throwable -> L6
            L12:
                r15.readException();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L8:
                r16 = null;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a(int r5, int r10, IDownloadAidlListener r11, int r12, boolean r13) {
                Parcel r14 = Parcel.obtain();
                Parcel r15 = Parcel.obtain();
                r14.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r14.writeInt(r5);     // Catch: Throwable -> L6
                r14.writeInt(r10);     // Catch: Throwable -> L6
                if (r11 == null) goto L8;
                IDownloadAidlListener.Stub r16 = (IDownloadAidlListener.Stub) r11;     // Catch: Throwable -> L6
            L9:
                r14.writeStrongBinder(r16);     // Catch: Throwable -> L6
                r14.writeInt(r12);     // Catch: Throwable -> L6
                r14.writeInt(0);     // Catch: Throwable -> L6
                if (this.f15571a.transact(24, r14, r15, 0) == true) goto L12;
                int r17 = Stub.f15570a;     // Catch: Throwable -> L6
            L12:
                r15.readException();     // Catch: Throwable -> L6
                r15.recycle();
                r14.recycle();
                return;
            L8:
                r16 = null;
            L6:
                th = move-exception;
                r15.recycle();
                r14.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final boolean b(int r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r10.writeInt(r5);     // Catch: Throwable -> L6
                boolean r12 = false;
                if (this.f15571a.transact(35, r10, r11, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() == 0) goto L11;
                r12 = true;
            L11:
                r11.recycle();
                r10.recycle();
                return r12;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a(int r5, boolean r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(r10 ? 1 : 0);     // Catch: Throwable -> L6
                if (this.f15571a.transact(32, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void b(int r5, int r10) {
                Parcel r11 = Parcel.obtain();
                Parcel r12 = Parcel.obtain();
                r11.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                r11.writeInt(r5);     // Catch: Throwable -> L6
                r11.writeInt(r10);     // Catch: Throwable -> L6
                if (this.f15571a.transact(40, r11, r12, 0) == true) goto L8;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r12.readException();     // Catch: Throwable -> L6
                r12.recycle();
                r11.recycle();
                return;
            L6:
                th = move-exception;
                r12.recycle();
                r11.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final boolean a(DownloadInfo r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                boolean r12 = true;
                if (r5 == null) goto L8;
                r10.writeInt(1);     // Catch: Throwable -> L6
                r5.writeToParcel(r10, 0);     // Catch: Throwable -> L6
            L10:
                if (this.f15571a.transact(34, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                if (r11.readInt() != 0) goto L16;
                r12 = false;
            L16:
                r11.recycle();
                r10.recycle();
                return r12;
            L8:
                r10.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a() {
                Parcel r5 = Parcel.obtain();
                Parcel r10 = Parcel.obtain();
                r5.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                if (this.f15571a.transact(37, r5, r10, 0) == true) goto L8;
                int r11 = Stub.f15570a;     // Catch: Throwable -> L6
            L8:
                r10.readException();     // Catch: Throwable -> L6
                r10.recycle();
                r5.recycle();
                return;
            L6:
                th = move-exception;
                r10.recycle();
                r5.recycle();
                throw th;
            }

            @Override // com.ss.android.socialbase.downloader.downloader.IDownloadAidlService
            public final void a(ProcessAidlCallback r5) {
                Parcel r10 = Parcel.obtain();
                Parcel r11 = Parcel.obtain();
                r10.writeInterfaceToken("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");     // Catch: Throwable -> L6
                if (r5 == null) goto L8;
                IBinder r12 = r5.asBinder();     // Catch: Throwable -> L6
            L9:
                r10.writeStrongBinder(r12);     // Catch: Throwable -> L6
                if (this.f15571a.transact(39, r10, r11, 0) == true) goto L12;
                int r13 = Stub.f15570a;     // Catch: Throwable -> L6
            L12:
                r11.readException();     // Catch: Throwable -> L6
                r11.recycle();
                r10.recycle();
                return;
            L8:
                r12 = null;
            L6:
                th = move-exception;
                r11.recycle();
                r10.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, "com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
        }

        public static IDownloadAidlService a(IBinder r5) {
            if (r5 != null) goto L5;
            return null;
        L5:
            IInterface r10 = r5.queryLocalInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r10 == null) goto L12;
            if ((r10 instanceof IDownloadAidlService) == false) goto L12;
            return (IDownloadAidlService) r10;
        L12:
            return new Proxy(r5);
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r22v0, types: [android.os.Parcel] */
        /* JADX WARN: Type inference failed for: r4v16, types: [int] */
        /* JADX WARN: Type inference failed for: r4v21 */
        /* JADX WARN: Type inference failed for: r4v22 */
        /* JADX WARN: Type inference failed for: r4v28 */
        /* JADX WARN: Type inference failed for: r4v30 */
        /* JADX WARN: Type inference failed for: r4v31 */
        /* JADX WARN: Type inference failed for: r4v6, types: [int] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Binder
        public final boolean onTransact(int r20, Parcel r21, Parcel r22, int r23) {
            if (r20 == 1598968902) goto L262;
            boolean r5 = false;
            boolean r10 = false;
            ?? r11 = 0;
            boolean r12 = false;
            boolean r13 = false;
            int r14 = 0;
            int r15 = 0;
            r15 = 0;
            ?? r16 = 0;
            r16 = 0;
            boolean r17 = false;
            List r18 = null;
            IDownloadAidlFileProvider.Stub r19 = null;
            INotificationClickAidlCallback.Stub r24 = null;
            IDownloadNotificationEventAidlListener.Stub r25 = null;
            DownloadInfo r26 = null;
            List r27 = null;
            DownloadInfo r28 = null;
            List r29 = null;
            r29 = null;
            List r30 = null;
            r30 = null;
            List r31 = null;
            ArrayList r32 = null;
            List r33 = null;
            DownloadInfo r34 = null;
            switch(r20) {
                case 1: goto L260;
                case 2: goto L251;
                case 3: goto L246;
                case 4: goto L238;
                case 5: goto L236;
                case 6: goto L234;
                case 7: goto L232;
                case 8: goto L220;
                case 9: goto L211;
                case 10: goto L209;
                case 11: goto L204;
                case 12: goto L198;
                case 13: goto L192;
                case 14: goto L183;
                case 15: goto L177;
                case 16: goto L171;
                case 17: goto L165;
                case 18: goto L157;
                case 19: goto L149;
                case 20: goto L147;
                case 21: goto L145;
                case 22: goto L136;
                case 23: goto L131;
                case 24: goto L125;
                case 25: goto L119;
                case 26: goto L105;
                case 27: goto L100;
                case 28: goto L88;
                case 29: goto L82;
                case 30: goto L80;
                case 31: goto L74;
                case 32: goto L69;
                case 33: goto L67;
                case 34: goto L62;
                case 35: goto L60;
                case 36: goto L58;
                case 37: goto L56;
                case 38: goto L54;
                case 39: goto L52;
                case 40: goto L46;
                case 41: goto L37;
                case 42: goto L25;
                case 43: goto L19;
                case 44: goto L10;
                case 45: goto L8;
                default: goto L7;
            };
        L8:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).a(r21.readInt(), r21.readLong(), r21.readInt());
            r22.writeNoException();
            return true;
        L10:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r35 = r21.readInt();
            ProcessDownloadHandler r36 = ((IndependentDownloadBinder) this).f15697b;
            if (r36 != null) goto L13;
            IDownloadAidlFileProvider r37 = null;
        L14:
            r22.writeNoException();
            if (r37 == null) goto L17;
            r19 = (IDownloadAidlFileProvider.Stub) r37;
        L17:
            r22.writeStrongBinder(r19);
            return true;
        L13:
            r37 = IPCUtils.a(r36.f15741a.c(r35));
            goto L14
        L19:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r38 = r21.readInt();
            IDownloadNotificationEventAidlListener r39 = IDownloadNotificationEventAidlListener.Stub.a(r21.readStrongBinder());
            ProcessDownloadHandler r40 = ((IndependentDownloadBinder) this).f15697b;
            if (r40 == null) goto L23;
            r40.f15741a.a(r38, IPCUtils.a(r39));
        L23:
            r22.writeNoException();
            return true;
        L25:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r41 = r21.readInt();
            ProcessDownloadHandler r42 = ((IndependentDownloadBinder) this).f15697b;
            if (r42 != null) goto L28;
            INotificationClickAidlCallback r43 = null;
        L32:
            r22.writeNoException();
            if (r43 == null) goto L35;
            r24 = (INotificationClickAidlCallback.Stub) r43;
        L35:
            r22.writeStrongBinder(r24);
            return true;
        L28:
            INotificationClickCallback r44 = r42.f15741a.h(r41);
            if (r44 != null) goto L31;
            Context r45 = DownloadComponentManager.f15515a;
            r44 = null;
        L31:
            r43 = IPCUtils.a(r44);
            goto L32
        L37:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r46 = r21.readInt();
            ProcessDownloadHandler r47 = ((IndependentDownloadBinder) this).f15697b;
            if (r47 != null) goto L40;
            IDownloadNotificationEventAidlListener r48 = null;
        L41:
            r22.writeNoException();
            if (r48 == null) goto L44;
            r25 = (IDownloadNotificationEventAidlListener.Stub) r48;
        L44:
            r22.writeStrongBinder(r25);
            return true;
        L40:
            r48 = IPCUtils.a(r47.f15741a.f(r46));
            goto L41
        L46:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r49 = r21.readInt();
            int r50 = r21.readInt();
            ProcessDownloadHandler r51 = ((IndependentDownloadBinder) this).f15697b;
            if (r51 == null) goto L50;
            r51.b(r49, r50);
        L50:
            r22.writeNoException();
            return true;
        L52:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).a(ProcessAidlCallback.Stub.a(r21.readStrongBinder()));
            r22.writeNoException();
            return true;
        L54:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).c(r21.readInt());
            r22.writeNoException();
            return true;
        L56:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).a();
            r22.writeNoException();
            return true;
        L58:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r52 = ((IndependentDownloadBinder) this).d(r21.readInt());
            r22.writeNoException();
            r22.writeInt(r52 ? 1 : 0);
            return true;
        L60:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r53 = ((IndependentDownloadBinder) this).b(r21.readInt());
            r22.writeNoException();
            r22.writeInt(r53 ? 1 : 0);
            return true;
        L62:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r21.readInt() == 0) goto L65;
            r26 = DownloadInfo.CREATOR.createFromParcel(r21);
        L65:
            boolean r54 = ((IndependentDownloadBinder) this).a(r26);
            r22.writeNoException();
            r22.writeInt(r54 ? 1 : 0);
            return true;
        L67:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r55 = DownloadProcessDispatcher.a().c(r21.readInt());
            r22.writeNoException();
            r22.writeInt(r55);
            return true;
        L69:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r56 = r21.readInt();
            if (r21.readInt() == 0) goto L72;
            r10 = true;
        L72:
            DownloadProcessDispatcher.a().a(r56, r10);
            r22.writeNoException();
            return true;
        L74:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ProcessDownloadHandler r57 = ((IndependentDownloadBinder) this).f15697b;
            if (r57 == null) goto L78;
            r11 = r57.f15742b.c();
        L78:
            r22.writeNoException();
            r22.writeInt(r11);
            return true;
        L80:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).p(r21.readInt());
            r22.writeNoException();
            return true;
        L82:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r58 = r21.readString();
            ProcessDownloadHandler r59 = ((IndependentDownloadBinder) this).f15697b;
            if (r59 == null) goto L86;
            r27 = r59.f15742b.a(r58);
        L86:
            r22.writeNoException();
            r22.writeTypedList(r27);
            return true;
        L88:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (((IndependentDownloadBinder) this).f15697b != null) goto L92;
        L95:
            r22.writeNoException();
            r22.writeInt(0);
            return true;
        L92:
            monitor-enter(DownloadComponentManager.class);
            Context r60 = DownloadComponentManager.f15515a;     // Catch: Throwable -> L97
            monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L97
        L97:
            th = move-exception;
            throw th;
        L100:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            if (r21.readInt() == 0) goto L103;
            r28 = DownloadInfo.CREATOR.createFromParcel(r21);
        L103:
            boolean r61 = ((IndependentDownloadBinder) this).q(r28);
            r22.writeNoException();
            r22.writeInt(r61 ? 1 : 0);
            return true;
        L105:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r62 = r21.readInt();
            int r63 = r21.readInt();
            IDownloadAidlListener r64 = IDownloadAidlListener.Stub.a(r21.readStrongBinder());
            int r65 = r21.readInt();
            if (r21.readInt() == 0) goto L108;
            boolean r110 = true;
        L110:
            if (r21.readInt() == 0) goto L112;
            boolean r111 = true;
        L113:
            ProcessDownloadHandler r66 = ((IndependentDownloadBinder) this).f15697b;
            if (r66 == null) goto L117;
            r66.f15741a.a(r62, r63, IPCUtils.a(r64), DownloadHelper.a(r65), r110, r111);
        L117:
            r22.writeNoException();
            return true;
        L112:
            r111 = false;
            goto L113
        L108:
            r110 = false;
            goto L110
        L119:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r112 = r21.readInt();
            int r113 = r21.readInt();
            IDownloadAidlListener r114 = IDownloadAidlListener.Stub.a(r21.readStrongBinder());
            int r115 = r21.readInt();
            if (r21.readInt() == 0) goto L122;
            boolean r116 = true;
        L123:
            ((IndependentDownloadBinder) this).b(r112, r113, r114, r115, r116);
            r22.writeNoException();
            return true;
        L122:
            r116 = false;
            goto L123
        L125:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r67 = r21.readInt();
            int r68 = r21.readInt();
            IDownloadAidlListener r69 = IDownloadAidlListener.Stub.a(r21.readStrongBinder());
            int r117 = r21.readInt();
            if (r21.readInt() == 0) goto L128;
            boolean r118 = true;
        L129:
            ((IndependentDownloadBinder) this).a(r67, r68, r69, r117, r118);
            r22.writeNoException();
            return true;
        L128:
            r118 = false;
            goto L129
        L131:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r70 = r21.readInt();
            if (r21.readInt() == 0) goto L134;
            r12 = true;
        L134:
            ((IndependentDownloadBinder) this).d(r70, r12);
            r22.writeNoException();
            return true;
        L136:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r71 = r21.readInt();
            if (r21.readInt() == 0) goto L139;
            boolean r72 = true;
        L141:
            if (r21.readInt() == 0) goto L143;
            r13 = true;
        L143:
            ((IndependentDownloadBinder) this).a(r71, r72, r13);
            r22.writeNoException();
            return true;
        L139:
            r72 = false;
            goto L141
        L145:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).b(r21.createStringArrayList());
            r22.writeNoException();
            return true;
        L147:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).a(r21.createStringArrayList());
            r22.writeNoException();
            return true;
        L149:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r73 = r21.readString();
            String r74 = r21.readString();
            ProcessDownloadHandler r75 = ((IndependentDownloadBinder) this).f15697b;
            if (r75 == null) goto L155;
            IDownloadCache r76 = r75.f15742b;
            if (r76 == null) goto L155;
            r29 = r76.a(r73, r74);
        L155:
            r22.writeNoException();
            r22.writeTypedList(r29);
            return true;
        L157:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ProcessDownloadHandler r77 = ((IndependentDownloadBinder) this).f15697b;
            if (r77 == null) goto L163;
            IDownloadCache r78 = r77.f15742b;
            if (r78 == null) goto L163;
            r30 = r78.d();
        L163:
            r22.writeNoException();
            r22.writeTypedList(r30);
            return true;
        L165:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r79 = r21.readString();
            ProcessDownloadHandler r80 = ((IndependentDownloadBinder) this).f15697b;
            if (r80 == null) goto L169;
            r31 = r80.f15742b.d(r79);
        L169:
            r22.writeNoException();
            r22.writeTypedList(r31);
            return true;
        L171:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r81 = r21.readString();
            ProcessDownloadHandler r82 = ((IndependentDownloadBinder) this).f15697b;
            if (r82 == null) goto L175;
            r32 = r82.f15741a.c(r81);
        L175:
            r22.writeNoException();
            r22.writeTypedList(r32);
            return true;
        L177:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r83 = r21.readString();
            ProcessDownloadHandler r84 = ((IndependentDownloadBinder) this).f15697b;
            if (r84 == null) goto L181;
            r33 = r84.f15742b.b(r83);
        L181:
            r22.writeNoException();
            r22.writeTypedList(r33);
            return true;
        L183:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r85 = r21.readString();
            String r86 = r21.readString();
            ProcessDownloadHandler r87 = ((IndependentDownloadBinder) this).f15697b;
            if (r87 == null) goto L187;
            Context r88 = DownloadComponentManager.f15515a;
            r34 = r87.f15741a.d(((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(r85, r86));
        L187:
            r22.writeNoException();
            if (r34 == null) goto L190;
            r22.writeInt(1);
            r34.writeToParcel(r22, 1);
        L191:
            return true;
        L190:
            r22.writeInt(0);
            goto L191
        L192:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r89 = r21.readString();
            String r90 = r21.readString();
            if (((IndependentDownloadBinder) this).f15697b == null) goto L196;
            Context r91 = DownloadComponentManager.f15515a;
            r14 = ((IDownloadIdGeneratorService) DownloadServiceManager.a(IDownloadIdGeneratorService.class)).a(r89, r90);
        L196:
            r22.writeNoException();
            r22.writeInt(r14);
            return true;
        L198:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            String r92 = r21.readString();
            ProcessDownloadHandler r93 = ((IndependentDownloadBinder) this).f15697b;
            if (r93 == null) goto L202;
            r18 = r93.f15741a.a(r92);
        L202:
            r22.writeNoException();
            r22.writeTypedList(r18);
            return true;
        L204:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            DownloadInfo r94 = ((IndependentDownloadBinder) this).a(r21.readInt());
            r22.writeNoException();
            if (r94 == null) goto L207;
            r22.writeInt(1);
            r94.writeToParcel(r22, 1);
        L208:
            return true;
        L207:
            r22.writeInt(0);
            goto L208
        L209:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            boolean r95 = ((IndependentDownloadBinder) this).f(r21.readInt());
            r22.writeNoException();
            r22.writeInt(r95 ? 1 : 0);
            return true;
        L211:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r96 = r21.readInt();
            ProcessDownloadHandler r97 = ((IndependentDownloadBinder) this).f15697b;
            if (r97 == null) goto L218;
            DownloadInfo r98 = r97.f15741a.d(r96);
            if (r98 == null) goto L218;
            r15 = r98.o();
        L218:
            r22.writeNoException();
            r22.writeInt(r15);
            return true;
        L220:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r99 = r21.readInt();
            ProcessDownloadHandler r100 = ((IndependentDownloadBinder) this).f15697b;
            if (r100 == null) goto L228;
            IDownloadCache r101 = r100.f15742b;
            if (r101 == null) goto L228;
            DownloadInfo r102 = r101.a(r99);
            if (r102 == null) goto L228;
            long r103 = r102.i();
        L230:
            r22.writeNoException();
            r22.writeLong(r103);
            return true;
        L228:
            r103 = 0;
            goto L230
        L232:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).b();
            r22.writeNoException();
            return true;
        L234:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).g(r21.readInt());
            r22.writeNoException();
            return true;
        L236:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).o(r21.readInt());
            r22.writeNoException();
            return true;
        L238:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r104 = r21.readInt();
            ProcessDownloadHandler r105 = ((IndependentDownloadBinder) this).f15697b;
            if (r105 == null) goto L244;
            AbsDownloadEngine r106 = r105.f15741a;
            if (r106 == null) goto L244;
            r16 = r106.j(r104);
        L244:
            r22.writeNoException();
            r22.writeInt(r16);
            return true;
        L246:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r107 = r21.readInt();
            if (r21.readInt() == 0) goto L249;
            r17 = true;
        L249:
            ((IndependentDownloadBinder) this).c(r107, r17);
            r22.writeNoException();
            return true;
        L251:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            int r108 = r21.readInt();
            if (r21.readInt() == 0) goto L254;
            r5 = true;
        L254:
            ProcessDownloadHandler r109 = ((IndependentDownloadBinder) this).f15697b;
            if (r109 == null) goto L258;
            r109.b(r108, r5);
        L258:
            r22.writeNoException();
            return true;
        L260:
            r21.enforceInterface("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            ((IndependentDownloadBinder) this).a(DownloadAidlTask.Stub.a(r21.readStrongBinder()));
            r22.writeNoException();
            return true;
        L7:
            return super.onTransact(r20, r21, r22, r23);
        L262:
            r22.writeString("com.ss.android.socialbase.downloader.downloader.IDownloadAidlService");
            return true;
        }
    }

    DownloadInfo a(int r5);

    void a();

    void a(int r5, int r10, IDownloadAidlListener r11, int r12, boolean r13);

    void a(int r5, boolean r10);

    void a(ProcessAidlCallback r5);

    void a(DownloadAidlTask r5);

    void a(ArrayList r5);

    boolean a(DownloadInfo r5);

    void b();

    void b(int r5, int r10);

    void b(int r5, int r10, IDownloadAidlListener r11, int r12, boolean r13);

    void b(int r5, boolean r10);

    void b(ArrayList r5);

    boolean b(int r5);

    void c(int r5);

    void c(int r5, boolean r10);

    boolean d(int r5);

    boolean f(int r5);

    void g(int r5);

    int i(int r5);

    void p(int r5);
}
