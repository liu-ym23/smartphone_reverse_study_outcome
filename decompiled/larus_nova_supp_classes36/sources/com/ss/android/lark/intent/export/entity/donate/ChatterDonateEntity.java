package com.ss.android.lark.intent.export.entity.donate;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/donate/ChatterDonateEntity;", "Lcom/ss/android/lark/intent/export/entity/donate/ScreenDonateEntity;", "chatterId", "", "chatterName", "avatarFile", "Ljava/io/File;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V", "getChatterId", "()Ljava/lang/String;", "getChatterName", "getAvatarFile", "()Ljava/io/File;", "parser", "R", "visitor", "Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;", "(Lcom/ss/android/lark/intent/export/entity/donate/IDonateEntityVisitor;)Ljava/lang/Object;", "toDesc", "toString", "component1", "component2", "component3", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ChatterDonateEntity extends ScreenDonateEntity {
    private final File avatarFile;
    private final String chatterId;
    private final String chatterName;

    public static /* synthetic */ ChatterDonateEntity copy$default(ChatterDonateEntity r0, String r1, String r2, File r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.chatterId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.chatterName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.avatarFile;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.chatterId;
    }

    public final String component2() {
        return this.chatterName;
    }

    public final File component3() {
        return this.avatarFile;
    }

    public final ChatterDonateEntity copy(String r2, String r3, File r4) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "chatterName");
        return new ChatterDonateEntity(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ChatterDonateEntity) == true) goto L8;
        return false;
    L8:
        ChatterDonateEntity r6 = (ChatterDonateEntity) r5;
        if (Intrinsics.areEqual(this.chatterId, r6.chatterId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterName, r6.chatterName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarFile, r6.avatarFile) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.chatterId.hashCode() * 31) + this.chatterName.hashCode()) * 31;
        File r1 = this.avatarFile;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ChatterDonateEntity(chatterId='");
        r0.append(this.chatterId);
        r0.append("', hasAvatar=");
        if (this.avatarFile == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(')');
        return r0.toString();
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public String toDesc() {
        return toString();
    }

    public final File getAvatarFile() {
        return this.avatarFile;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public final String getChatterName() {
        return this.chatterName;
    }

    @Override // com.ss.android.lark.intent.export.entity.donate.ScreenDonateEntity
    public <R> R parser(IDonateEntityVisitor<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "visitor");
        return r2.visit(this);
    }

    public ChatterDonateEntity(String r2, String r3, File r4) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        Intrinsics.checkNotNullParameter(r3, "chatterName");
        super(DonateType.Chatter);
        this.chatterId = r2;
        this.chatterName = r3;
        this.avatarFile = r4;
    }
}
