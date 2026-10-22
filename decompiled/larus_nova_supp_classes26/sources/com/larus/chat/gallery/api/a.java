package com.larus.chat.gallery.api;

import android.app.Dialog;
import com.larus.chat.gallery.impl.preview.toolbar.action.k0;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.InputDraftSnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class a implements q {
    public final String a;
    public final String b;

    /* JADX INFO: renamed from: com.larus.chat.gallery.api.a$a, reason: collision with other inner class name */
    public static final class C0096a<T> implements Comparator {
        public C0096a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((AttachmentSnapshot) r1).getSelectedOrder()), Integer.valueOf(((AttachmentSnapshot) r2).getSelectedOrder()));
        }
    }

    @Override // com.larus.chat.gallery.api.u
    public abstract boolean Oa(String r1);

    @Override // com.larus.chat.gallery.api.u
    public abstract List<AttachmentSnapshot> Qa();

    @Override // com.larus.chat.gallery.api.n
    public abstract String a();

    @Override // com.larus.chat.gallery.api.q
    public Boolean n() {
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public String o() {
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public z p() {
        return null;
    }

    @Override // com.larus.chat.gallery.api.t
    public boolean t(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return false;
    }

    public a() {
        dr9.g r0 = dr9.g.a;
        this.a = dr9.g.e("preview-access");
        this.b = dr9.g.e("preview-owner");
    }

    @Override // com.larus.chat.gallery.api.x
    public final w h() {
        List r3 = CollectionsKt.sortedWith(Qa(), new C0096a());
        if (r3.isEmpty() == true) goto L20;
        List r0 = r3;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        boolean r2 = true;
        if ((!((AttachmentSnapshot) r1.next()).canEnterSendPipeline()) == false) goto L11;
    L16:
        if (r2 == false) goto L19;
        return null;
    L19:
        return new w(r3, a(), null, null, null, null, null, 252);
    L15:
        r2 = false;
        goto L16
    L7:
        if (r0.isEmpty() == false) goto L9;
    L20:
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public final String j() {
        return this.b;
    }

    @Override // com.larus.chat.gallery.api.q
    public String k() {
        return this.a;
    }

    @Override // com.larus.chat.gallery.api.q
    public void c(Dialog r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
    }

    @Override // com.larus.chat.gallery.api.q
    public PreviewSelectionLimit e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public String getTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public final InputDraftSnapshot i(String r27) {
        Intrinsics.checkNotNullParameter(r27, "sourceNodeId");
        String r2 = a();
        List<AttachmentSnapshot> r0 = Qa();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        AttachmentSnapshot r4 = (AttachmentSnapshot) r1.next();
        r3.add(AttachmentSnapshot.copy$default(r4, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.toMap(r4.getExtra()), 65535, null));
        goto L4
    L7:
        return new InputDraftSnapshot(r2, r3, r27, 0, 8, null);
    }

    @Override // com.larus.chat.gallery.api.q
    public PreviewSelectionLimit r(PreviewMediaType r2) {
        Intrinsics.checkNotNullParameter(r2, "mediaType");
        return null;
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean w(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemKey");
        return true;
    }

    @Override // com.larus.chat.gallery.api.u
    public a0 Pa(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "itemKey");
        int r3 = a0.d;
        return a0.a.a(Oa(r1), SelectResultReason.NOT_SUPPORTED);
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean l(PreviewSourceAction r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "itemKey");
        return false;
    }

    @Override // com.larus.chat.gallery.api.q
    public boolean v(PreviewSourceAction r2, String r3, k0 r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "itemKey");
        Intrinsics.checkNotNullParameter(r4, "onResult");
        return false;
    }
}
