package com.larus.drive.sdk.impl.gallery;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.chat.gallery.api.PreviewSendFailureReason;
import com.larus.chat.gallery.api.PreviewSourceAction;
import com.larus.chat.gallery.api.r;
import com.larus.chat.gallery.api.v;
import com.larus.chat.gallery.api.w;
import com.larus.chat.gallery.api.y;
import com.larus.chat.gallery.api.z;
import com.larus.chat.gallery.impl.preview.provider.x0;
import com.larus.chat.gallery.impl.preview.provider.y0;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.biz.impl.viewmodel.AbsDriveListViewModel;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.api.meta.PreviewFromPage;
import com.larus.drive.sdk.impl.gallery.datasource.DriveGalleryDataSource;
import com.larus.drive.sdk.impl.gallery.provider.DriveGalleryInputProvider;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.utils.MorePanelHelper;
import com.larus.drive.sdk.impl.view.chat.DriveInputFragment;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.ProviderType;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.c2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import t19.s;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DriveGalleryHelper {
    public static final DriveGalleryHelper a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final e89.c e = null;

    public static final class DrivePreviewMediaSession extends com.larus.chat.gallery.api.a {
        public final z79.b c;
        public final List<com.larus.chat.gallery.api.o> d;
        public final Map<String, z79.c> e;
        public final Map<String, DriveFileItem> f;
        public final DrivePreviewSourceInput g;
        public final List<AttachmentSnapshot> h;
        public final Map<String, AttachmentSnapshot> i;
        public final Set<String> j;
        public final Set<Function1<List<AttachmentSnapshot>, Unit>> k;
        public String l;
        public String m;
        public boolean n;
        public volatile boolean o;
        public final com.larus.chat.gallery.api.l p;

        public final class DrivePreviewSourceInput implements z {
            public z79.c a;
            public Function0<Unit> b;
            public Function1<? super String, Unit> c;
            public Function2<? super String, ? super Boolean, Unit> d;
            public Function0<Unit> e;
            public Function0<Unit> f;
            public boolean g;
            public final Lazy h;
            public final /* synthetic */ DrivePreviewMediaSession i;

            public final DriveInputFragment h() {
                return (DriveInputFragment) this.h.getValue();
            }

            public final DriveInputFragment a() {
                return h();
            }

            public DrivePreviewSourceInput(DrivePreviewMediaSession r2) {
                this.i = r2;
                this.a = r2.e.get(r2.c.b.b);
                this.h = LazyKt.lazy(new k(this));
            }

            public final void b(Function0<Unit> r1) {
                this.f = r1;
            }

            public final void c(Function0<Unit> r1) {
                this.e = r1;
            }

            public final void d(String r3) {
                Intrinsics.checkNotNullParameter(r3, "itemKey");
                DrivePreviewMediaSession r0 = this.i;
                r0.l = r3;
                z79.c r4 = r0.e.get(r3);
                this.a = r4;
                DriveGalleryHelper r1 = DriveGalleryHelper.a;
                if (r4 == null) goto L5;
                DriveFileItem r5 = r4.a;
            L6:
                final boolean r6 = DriveGalleryHelper.c(r5);
                View r2 = h().getView();
                if (r2 == null) goto L9;
                r2.post(new l(this, r6));
            L9:
                this.i.x();
                return;
            L5:
                r5 = null;
                goto L6
            }

            public final void e(x0 r1) {
                this.b = r1;
            }

            public final void f(y0 r1) {
                this.d = r1;
            }

            public final void g(Function1<? super String, Unit> r1) {
                this.c = r1;
            }

            public final void i(boolean r3) {
                if (r3 == false) goto L7;
                Function0<Unit> r4 = this.b;
                if (r4 == null) goto L15;
                r4.invoke();
                return;
            L15:
                return;
            L7:
                DriveGalleryHelper r5 = DriveGalleryHelper.a;
                z79.c r6 = this.a;
                if (r6 == null) goto L10;
                DriveFileItem r7 = r6.a;
            L11:
                final boolean r8 = DriveGalleryHelper.c(r7);
                View r0 = h().getView();
                if (r0 == null) goto L16;
                r0.post(new m(this, r8));
                return;
            L16:
                return;
            L10:
                r7 = null;
                goto L11
            }
        }

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;
            public static final /* synthetic */ int[] b = null;

            static {
                int[] r0 = new int[PreviewSourceAction.values().length];
                r0[PreviewSourceAction.SHARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
            L23:
                r0[PreviewSourceAction.DOWNLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
            L33:
                r0[PreviewSourceAction.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
            L25:
                r0[PreviewSourceAction.RENAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
            L27:
                r0[PreviewSourceAction.MOVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
            L9:
                a = r0;
                int[] r1 = new int[DriveFileType.values().length];
                r1[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
            L21:
                r1[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
            L12:
                b = r1;
            }
        }

        public final boolean g() {
            return true;
        }

        public final void u() {
            this.o = false;
        }

        public final List<AttachmentSnapshot> Qa() {
            List r1 = CollectionsKt.createListBuilder();
            DriveFileItem r2 = this.f.get(this.l);
            AttachmentSnapshot r4 = null;
            if (r2 != null) goto L6;
        L33:
            if (r4 == null) goto L35;
            r1.add(r4);
        L35:
            List<AttachmentSnapshot> r3 = this.h;
            ArrayList r5 = new ArrayList();
            Iterator<T> r6 = r3.iterator();
        L37:
            if (r6.hasNext() == false) goto L41;
            Object r7 = r6.next();
            if (this.j.contains(((AttachmentSnapshot) r7).getStableId()) == true) goto L37;
            r5.add(r7);
            goto L37
        L41:
            r1.addAll(r5);
            List r8 = CollectionsKt.build(r1);
            HashSet r9 = new HashSet();
            ArrayList r10 = new ArrayList();
            Iterator r11 = r8.iterator();
        L43:
            if (r11.hasNext() == false) goto L47;
            Object r12 = r11.next();
            if (r9.add(((AttachmentSnapshot) r12).getStableId()) == false) goto L43;
            r10.add(r12);
            goto L43
        L47:
            ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r14 = r10.iterator();
            int r20 = 0;
        L49:
            if (r14.hasNext() == false) goto L54;
            Object r15 = r14.next();
            int r25 = r20 + 1;
            if (r20 >= 0) goto L53;
            CollectionsKt.throwIndexOverflow();
        L53:
            r13.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r15, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, r20, null, null, 114687, null));
            r20 = r25;
            goto L49
        L54:
            return r13;
        L6:
            if (this.j.contains(r2.b) == true) goto L33;
            AttachmentSnapshot r16 = (AttachmentSnapshot) ((LinkedHashMap) this.i).get(r2.b);
            if (r16 == null) goto L11;
            r4 = r16;
            goto L33
        L11:
            String r17 = r2.e;
            if (StringsKt.isBlank(r17) == false) goto L14;
            r17 = r2.b;
        L14:
            String r18 = r17;
            if (StringsKt.isBlank(r2.e) == false) goto L17;
            ResourceRefKind r21 = ResourceRefKind.CLOUD_TOKEN;
        L18:
            ResourceRef r22 = new ResourceRef(r18, r21, r2.b, 0, 0, 24, null);
            int r23 = a.b[r2.j.ordinal()];
            boolean r24 = true;
            if (r23 != 1) goto L21;
            AttachmentMediaType r26 = AttachmentMediaType.IMAGE;
        L25:
            String r27 = r2.e;
            String r28 = r2.b;
            String r110 = r2.a;
            int r111 = r2.d;
            DriveUplinkInfo r112 = new DriveUplinkInfo(r27, r28, r110, r111, r111, "input_ai_space");
            String r113 = r2.b;
            AttachmentSource r114 = AttachmentSource.CLOUD_DRIVE;
            if (r26 != AttachmentMediaType.FILE) goto L29;
            r24 = false;
        L29:
            if (r24 == false) goto L31;
            ResourceRef r115 = r22;
        L32:
            r4 = new AttachmentSnapshot(r113, r114, r26, r22, r115, r22, r2.a, null, Long.valueOf(r2.e()), r2.b, null, 0, AttachmentUploadState.UPLOADED, null, 0, AttachmentSendableState.SENDABLE, MapsKt.mapOf(TuplesKt.to("drive_uplink_info", r112.toString())), 27776, null);
            goto L33
        L31:
            r115 = null;
            goto L32
        L21:
            if (r23 == 2) goto L23;
            r26 = AttachmentMediaType.FILE;
            goto L25
        L23:
            r26 = AttachmentMediaType.VIDEO;
            goto L25
        L17:
            r21 = ResourceRefKind.REMOTE_URL;
            goto L18
        }

        public final void x() {
            List<AttachmentSnapshot> r0 = Qa();
            Iterator r1 = CollectionsKt.toList(this.k).iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ((Function1) r1.next()).invoke(r0);
            goto L4
        }

        public final String a() {
            return this.m;
        }

        public final List<com.larus.chat.gallery.api.o> d() {
            return this.d;
        }

        public final com.larus.chat.gallery.api.l getCapability() {
            return this.p;
        }

        public final z p() {
            return this.g;
        }

        public final boolean Oa(String r4) {
            Intrinsics.checkNotNullParameter(r4, "itemKey");
            List<AttachmentSnapshot> r0 = Qa();
            if (r0.isEmpty() == true) goto L15;
            Iterator<T> r1 = r0.iterator();
        L7:
            if (r1.hasNext() == false) goto L16;
            if (Intrinsics.areEqual(((AttachmentSnapshot) r1.next()).getStableId(), r4) == false) goto L7;
            return true;
        L16:
            return false;
        L15:
            return false;
        }

        public final void b(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.k.remove(r2);
        }

        public final void c(Dialog r4) {
            Intrinsics.checkNotNullParameter(r4, "dialog");
            DriveFileItem r0 = this.c.b;
            DriveGalleryHelper.e.o(r0.b, r0.d, r4);
        }

        public final void f(Function1<? super List<AttachmentSnapshot>, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "listener");
            this.k.add(r2);
        }

        public final String getTitle(String r2) {
            Intrinsics.checkNotNullParameter(r2, "itemKey");
            DriveFileItem r3 = this.f.get(r2);
            if (r3 != null) goto L7;
            return null;
        L7:
            return r3.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.drive.sdk.impl.gallery.o] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.larus.drive.sdk.impl.gallery.j, java.lang.Object] */
        public final v m(w r12) {
            Intrinsics.checkNotNullParameter(r12, "snapshot");
            if (this.n == false) goto L6;
            int r13 = v.d;
            return v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L6:
            List<AttachmentSnapshot> r1 = Qa();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r3 = ((ArrayList) r1).iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r2.add(((AttachmentSnapshot) r3.next()).getStableId());
            goto L8
        L10:
            List r4 = r12.a;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = r4.iterator();
        L12:
            if (r6.hasNext() == false) goto L15;
            r5.add(((AttachmentSnapshot) r6.next()).getStableId());
            goto L12
        L15:
            if (Intrinsics.areEqual(r2, r5) == true) goto L18;
            int r14 = v.d;
            return v.a.a(PreviewSendFailureReason.NOT_SENDABLE);
        L18:
            this.n = true;
            final DrivePreviewSourceInput r7 = this.g;
            DriveFileItem r8 = this.f.get(this.l);
            ?? r9 = new j(this);
            r7.getClass();
            Intrinsics.checkNotNullParameter(r12, "snapshot");
            Intrinsics.checkNotNullParameter(r9, "onResult");
            boolean r10 = r7.g;
            r7.g = false;
            View r11 = r7.h().getView();
            if (r11 == null) goto L21;
            r11.post(new n(r7));
        L21:
            r79.a r15 = (r79.a) s1a.a.g(r7.h()).getAbility(r79.a.class);
            if (r15 == 0) goto L26;
            String r16 = r12.b;
            List r17 = r12.a;
            final DrivePreviewMediaSession r18 = r7.i;
            if (r15.OG(r16, r17, r8, r10, r9, new o(r18)) != true) goto L26;
            boolean r110 = true;
        L27:
            if (r110 == true) goto L33;
            this.n = false;
            this.g.i(false);
            int r111 = v.d;
            return v.a.a(PreviewSendFailureReason.HOST_UNAVAILABLE);
        L33:
            return new v(true, null, 2);
        L26:
            r110 = false;
            goto L27
        }

        public final boolean q(r r30) {
            Intrinsics.checkNotNullParameter(r30, "mutation");
            int r4 = 0;
            if ((r30 instanceof r.b) == false) goto L22;
            r.b r1 = (r.b) r30;
            String r2 = r1.a;
            Iterator r5 = ((ArrayList) this.h).iterator();
            int r6 = 0;
        L6:
            if (r5.hasNext() == false) goto L11;
            if (Intrinsics.areEqual(((AttachmentSnapshot) r5.next()).getStableId(), r2) == true) goto L13;
            r6 = r6 + 1;
        L13:
            if (this.f.containsKey(r2) == true) goto L16;
            if (r6 >= 0) goto L16;
            return false;
        L16:
            AttachmentSnapshot r7 = r1.b;
            int r3 = r6;
            AttachmentSnapshot r8 = AttachmentSnapshot.copy$default(r7, r2, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, null, 131070, null);
            if (this.f.containsKey(r2) == false) goto L19;
            this.i.put(r2, r8);
        L20:
            this.j.remove(r2);
            x();
        L68:
            return true;
        L19:
            ListProtector.set(this.h, r3, r8);
            goto L20
        L11:
            r6 = -1;
            goto L13
        L22:
            if ((r30 instanceof r.a) == false) goto L71;
            List r9 = ((r.a) r30).a;
            List r10 = r9;
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator r12 = r10.iterator();
        L25:
            if (r12.hasNext() == false) goto L27;
            r11.add(((AttachmentSnapshot) r12.next()).getStableId());
            goto L25
        L27:
            Set<String> r13 = this.f.keySet();
            List<AttachmentSnapshot> r14 = this.h;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator r16 = ((ArrayList) r14).iterator();
        L29:
            if (r16.hasNext() == false) goto L31;
            r15.add(((AttachmentSnapshot) r16.next()).getStableId());
            goto L29
        L31:
            Set r17 = SetsKt.plus(r13, r15);
            if (r9.isEmpty() == false) goto L34;
        L69:
            return false;
        L34:
            if (r11.isEmpty() == true) goto L42;
            Iterator r18 = r11.iterator();
        L38:
            if (r18.hasNext() == false) goto L42;
            if (StringsKt.isBlank((String) r18.next()) == false) goto L38;
            boolean r20 = true;
        L43:
            if (r20 == true) goto L69;
            if (r11.size() != CollectionsKt.distinct(r11).size()) goto L69;
            if (r11.isEmpty() == true) goto L55;
            Iterator r21 = r11.iterator();
        L51:
            if (r21.hasNext() == false) goto L55;
            if (r17.contains((String) r21.next()) == false) goto L51;
            boolean r22 = true;
        L56:
            if (r22 == true) goto L69;
            int r23 = ((ArrayList) Qa()).size() + r9.size();
            ImFileUtil.a.getClass();
            if (r23 > ImFileUtil.m()) goto L69;
            List r24 = r9;
            ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
            Iterator r26 = r24.iterator();
        L62:
            if (r26.hasNext() == false) goto L67;
            Object r27 = r26.next();
            int r28 = r4 + 1;
            if (r4 >= 0) goto L66;
            CollectionsKt.throwIndexOverflow();
        L66:
            r25.add(AttachmentSnapshot.copy$default((AttachmentSnapshot) r27, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, (((ArrayList) this.h).size() + r4) + 1, null, null, 114687, null));
            r4 = r28;
            goto L62
        L67:
            ((ArrayList) this.h).addAll(r25);
            this.j.removeAll(CollectionsKt.toSet(r11));
            x();
        L55:
            r22 = false;
        L42:
            r20 = false;
            goto L43
        L71:
            throw new NoWhenBranchMatchedException();
        }

        public final boolean s(String r2) {
            Intrinsics.checkNotNullParameter(r2, "text");
            this.m = r2;
            return true;
        }

        public final boolean t(String r2) {
            Intrinsics.checkNotNullParameter(r2, "itemKey");
            if (Oa(r2) == true) goto L6;
            return false;
        L6:
            this.j.add(r2);
            x();
            return true;
        }

        public final boolean l(PreviewSourceAction r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter(r5, "itemKey");
            DriveFileItem r6 = this.f.get(r5);
            if (r6 != null) goto L5;
            return false;
        L5:
            int r7 = a.a[r4.ordinal()];
            if (r7 != 1) goto L8;
        L34:
            return true;
        L8:
            if (r7 == 2) goto L34;
            if (r7 == 3) goto L34;
            if (r7 == 4) goto L23;
            if (r7 != 5) goto L21;
            if (r6.g() == true) goto L34;
            if (this.c.e == PreviewFromPage.MINE) goto L34;
            return false;
        L21:
            throw new NoWhenBranchMatchedException();
        L23:
            if (r6.g() == false) goto L37;
            DriveFileType r8 = r6.j;
            if (r8 != DriveFileType.AI_DOC) goto L27;
        L32:
            boolean r9 = true;
        L33:
            if (r9 == false) goto L34;
            return false;
        L27:
            if (r8 == DriveFileType.AI_SLIDES) goto L32;
            if (r8 == DriveFileType.AI_SHEET) goto L32;
            r9 = false;
            goto L33
        L37:
            return false;
        }

        public DrivePreviewMediaSession(z79.b r10, List<z79.c> r11, List<com.larus.chat.gallery.api.o> r12) {
            Intrinsics.checkNotNullParameter(r10, "galleryContext");
            Intrinsics.checkNotNullParameter(r11, "galleryData");
            Intrinsics.checkNotNullParameter(r12, "items");
            this.c = r10;
            this.d = r12;
            List<z79.c> r13 = r11;
            ArrayList r14 = new ArrayList();
            Iterator<T> r15 = r13.iterator();
        L3:
            Pair r1 = null;
            if (r15.hasNext() == false) goto L12;
            z79.c r0 = (z79.c) r15.next();
            DriveFileItem r2 = r0.a;
            if (r2 == null) goto L10;
            String r3 = r2.b;
            if (r3 == null) goto L10;
            r1 = TuplesKt.to(r3, r0);
        L10:
            if (r1 == null) goto L3;
            r14.add(r1);
            goto L3
        L12:
            this.e = MapsKt.toMutableMap(MapsKt.toMap(r14));
            ArrayList r16 = new ArrayList();
            Iterator<T> r17 = r13.iterator();
        L14:
            if (r17.hasNext() == false) goto L21;
            DriveFileItem r18 = ((z79.c) r17.next()).a;
            if (r18 == null) goto L18;
            Pair r110 = TuplesKt.to(r18.b, r18);
        L19:
            if (r110 == null) goto L14;
            r16.add(r110);
            goto L14
        L18:
            r110 = null;
            goto L19
        L21:
            this.f = MapsKt.toMutableMap(MapsKt.toMap(r16));
            this.g = new DrivePreviewSourceInput(this);
            this.h = new ArrayList();
            this.i = new LinkedHashMap();
            this.j = new LinkedHashSet();
            this.k = new LinkedHashSet();
            this.l = this.c.b.b;
            this.m = "";
            this.o = true;
            this.p = new com.larus.chat.gallery.api.l(true, false, true, true, true, true, true, 2);
        }

        public final boolean v(PreviewSourceAction r54, String r55, k0 r56) {
            Intrinsics.checkNotNullParameter(r54, "action");
            Intrinsics.checkNotNullParameter(r55, "itemKey");
            Intrinsics.checkNotNullParameter(r56, "onResult");
            DriveFileItem r6 = this.f.get(r55);
            if (r6 != null) goto L6;
            return false;
        L6:
            if (l(r54, r55) == true) goto L9;
            return false;
        L9:
            if (r54 != PreviewSourceAction.SHARE) goto L12;
            BuildersKt.launch$default(this.c.c, null, null, new DriveGalleryHelper$DrivePreviewMediaSession$performSourceAction$1(r6, this, r56, null), 3, null);
            return true;
        L12:
            int r2 = a.a[r54.ordinal()];
            if (r2 != 1) goto L15;
            int r13 = AbsDriveListViewModel.MENU_ID_SHARE;
        L29:
            Lazy r3 = MorePanelHelper.a;
            MorePanelHelper.e(new l0(r13, 0, "", null, null, null, null, null, null, false, false, null, 0, null, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -4102, 127), r6, this.c.getContext(), this.c.c, new p(this, r56), 32);
            if (r54 != PreviewSourceAction.DOWNLOAD) goto L32;
        L33:
            r56.invoke(y.a.a);
        L34:
            return true;
        L32:
            if (r54 != PreviewSourceAction.MOVE) goto L34;
        L15:
            if (r2 != 2) goto L17;
            r13 = AbsDriveListViewModel.MENU_ID_DOWNLOAD;
            goto L29
        L17:
            if (r2 != 3) goto L19;
            r13 = AbsDriveListViewModel.MENU_ID_DELETE;
            goto L29
        L19:
            if (r2 != 4) goto L21;
            r13 = AbsDriveListViewModel.MENU_ID_RENAME;
            goto L29
        L21:
            if (r2 != 5) goto L24;
            r13 = AbsDriveListViewModel.MENU_ID_MOVE;
            goto L29
        L24:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class a {
        public final z0 a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            z0 r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "EditConfig(customActionBarItem=" + this.a + ')';
        }

        public a(z0 r1) {
            this.a = r1;
        }
    }

    public DriveGalleryHelper() {
    }

    static {
        a = new DriveGalleryHelper();
        b = LazyKt.lazy(new com.larus.drive.sdk.impl.gallery.a());
        c = LazyKt.lazy(new b());
        d = LazyKt.lazy(new c());
        e = t.a();
    }

    public static String b() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.W();
    L7:
        return null;
    }

    public static boolean c(DriveFileItem r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = r7.e();
        if (r7.j != DriveFileType.IMAGE) goto L10;
        if (r1 <= ((Number) c.getValue()).longValue()) goto L10;
    L11:
        boolean r2 = true;
    L13:
        boolean r3 = r7.b();
        boolean r4 = UploadFilePolicy.a;
        boolean r8 = !UploadFilePolicy.e(r7.d(false));
        if (r2 == true) goto L19;
        if (r3 == true) goto L20;
        if (r8 == true) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    L10:
        if (UploadFilePolicy.f(r1) == false) goto L11;
        r2 = false;
        goto L13
    }

    public static void d(z79.b r13) {
        Intrinsics.checkNotNullParameter(r13, "galleryContext");
        DriveFileItem r0 = r13.b;
        if (StringsKt.isBlank(r0.b) == false) goto L6;
        FLogger.a.i("DriveGalleryHelper", "[openPreview] Error file token=" + r0.b);
        return;
    L6:
        String r3 = r0.d(true).toLowerCase(Locale.ROOT);
        if (((List) d.getValue()).contains(r3) == false) goto L10;
        s r1 = s.a;
        Context r14 = r13.getContext();
        r1.getClass();
        s.s(r14, 2131905421);
        FLogger.a.i("DriveGalleryHelper", "[openPreview] File type not support preview; postfix=" + r3);
        return;
    L10:
        int r4 = Build.VERSION.SDK_INT;
        if (r4 <= 29) goto L13;
    L16:
        e.q(r0.b, r0.d);
        AccountService.a.p("open_document", System.currentTimeMillis(), MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_type", r0.j.getValue()), TuplesKt.to("resource_id", r0.b)}), "DriveGalleryHelper");
        BuildersKt.launch$default(r13.c, null, null, new DriveGalleryHelper$openPreview$1(r13, r0, null), 3, null);
        return;
    L13:
        if (CollectionsKt.listOf(new DriveFileType[]{DriveFileType.AI_DOC, DriveFileType.AI_SLIDES, DriveFileType.AI_SHEET}).contains(r0.j) == false) goto L16;
        s r2 = s.a;
        Context r15 = r13.getContext();
        r2.getClass();
        s.s(r15, 2131897531);
        FLogger.a.i("DriveGalleryHelper", "[openPreview] <= Android 10, not support preview; os=" + r4);
    }

    public static final Object a(DriveGalleryHelper r42, z79.b r43, Continuation r44) {
        final z79.b r0 = r43;
        r42.getClass();
        if ((r44 instanceof DriveGalleryHelper$openMediaPreview$1) == false) goto L7;
        DriveGalleryHelper$openMediaPreview$1 r2 = (DriveGalleryHelper$openMediaPreview$1) r44;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        r0 = (z79.b) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L18:
        if (((Boolean) r1).booleanValue() == true) goto L99;
        r0.b.getClass();
        Pair<Integer, Integer> r6 = t.b().a(r0.getContext());
        final LifecycleCoroutineScope r7 = r0.c;
        Intrinsics.checkNotNullParameter(r7, "scope");
        final String r8 = b();
        String r9 = b();
        IActionBarService r10 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        String r11 = "";
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        List r12 = r10.f(r9);
        if (r12 == null) goto L41;
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L39;
        Object r14 = r13.next();
        com.larus.bmhome.actionbar.model.r r15 = ((z0) r14).q;
        if (r15 == null) goto L36;
        Integer r16 = r15.a;
        if (r16 == null) goto L36;
        if (r16.intValue() != 24) goto L36;
        boolean r17 = true;
    L37:
        if (r17 == false) goto L27;
    L40:
        z0 r18 = (z0) r14;
    L42:
        final a r20 = new a(r18);
        String r21 = b();
        IActionBarService r110 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r21 == null) goto L46;
        r11 = r21;
    L46:
        List r22 = r110.f(r11);
        if (r22 == null) goto L64;
        Iterator r23 = r22.iterator();
    L50:
        if (r23.hasNext() == false) goto L62;
        Object r24 = r23.next();
        com.larus.bmhome.actionbar.model.r r111 = ((z0) r24).q;
        if (r111 == null) goto L59;
        Integer r112 = r111.a;
        if (r112 == null) goto L59;
        if (r112.intValue() != 16) goto L59;
        boolean r113 = true;
    L60:
        if (r113 == false) goto L50;
    L63:
        z0 r25 = (z0) r24;
    L65:
        final a r26 = new a(r25);
        z79.a r27 = new z79.a(new ic8.d(true, new e(r20, r8), null, false, null, null, 60), new ic8.d(true, new f(r26, r8), null, false, null, null, 60), new ic8.d(true, new g(r7), null, false, null, null, 60), new ic8.d(true, new h(r7), null, false, null, null, 60));
        GalleryBuilder r28 = new GalleryBuilder(r0.getContext());
        DriveGalleryDataSource r30 = new DriveGalleryDataSource(r0);
        Intrinsics.checkNotNullParameter(r30, "dataSource");
        r28.b = r30;
        r28.c = 0;
        com.larus.gallery.api.b r31 = new com.larus.gallery.api.b(new com.larus.gallery.api.a(((Number) r6.getFirst()).intValue(), ((Number) r6.getSecond()).intValue(), DisplayGravity.TOP, new com.larus.gallery.adapter.ui.i(i5.Z())), false, null, 10, false, false, false, null, null, false, 32510);
        Intrinsics.checkNotNullParameter(r31, "displayConfig");
        r28.d = r31;
        r28.a(ProviderType.TOP, new com.larus.drive.sdk.impl.gallery.provider.h(r0));
        r28.a(ProviderType.BOTTOM, new DriveGalleryInputProvider(r0));
        r28.a(ProviderType.RIGHT_SIDE, new com.larus.drive.sdk.impl.gallery.provider.c(r0, r27));
        Function1 r32 = new d(r0);
        Intrinsics.checkNotNullParameter(r32, "listener");
        r28.g = r32;
        GenericDraweeView r33 = r0.g;
        if (r33 != null) goto L68;
    L86:
        r33 = null;
    L87:
        Intrinsics.checkNotNullParameter("drive_media_preview_dialog", "tag");
        r28.m = "drive_media_preview_dialog";
        r28.l = r33;
        r28.b(null);
        return Unit.INSTANCE;
    L68:
        if (((c2) b.getValue()).f() == true) goto L70;
    L83:
        boolean r34 = false;
    L84:
        if (r34 == false) goto L86;
    L70:
        if ((r33 instanceof GenericDraweeView) == false) goto L83;
        if (r33.getVisibility() != 0) goto L74;
        boolean r35 = true;
    L75:
        if (r35 == false) goto L83;
        GenericDraweeView r36 = r33;
        if (r36.getWidth() <= 0) goto L83;
        if (r36.getHeight() <= 0) goto L83;
        if (r36.getDrawable() == null) goto L83;
        r34 = true;
        goto L84
    L74:
        r35 = false;
    L59:
        r113 = false;
        goto L60
    L62:
        r24 = null;
        goto L63
    L64:
        r25 = null;
    L36:
        r17 = false;
        goto L37
    L39:
        r14 = null;
        goto L40
    L41:
        r18 = null;
        goto L42
    L99:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        r2.L$0 = r0;
        r2.label = 1;
        r1 = CoroutineScopeKt.coroutineScope(new DriveGalleryHelper$tryOpenUnifiedMediaPreview$2(r0, null), r2);
        if (r1 != r4) goto L18;
        return r4;
    L7:
        r2 = new DriveGalleryHelper$openMediaPreview$1(r42, r44);
        goto L8
    }
}
