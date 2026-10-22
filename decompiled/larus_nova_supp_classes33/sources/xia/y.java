package xia;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class y implements c {
    public static final y a = null;

    static {
        a = new y();
    }

    public y() {
    }

    @Override // xia.c
    public final int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof ContactEntity) == false) goto L54;
        ContactEntity r4 = (ContactEntity) r3;
        int r0 = r4.getName().hashCode() + 0;
        List r1 = r4.getTelephones();
        if (r1 == null) goto L7;
        r0 = (r0 * 31) + r1.hashCode();
    L7:
        FileEntity r2 = r4.getAvatar();
        if (r2 == null) goto L10;
        r0 = (r0 * 31) + r2.hashCode();
    L10:
        String r5 = r4.getNote();
        if (r5 == null) goto L13;
        r0 = (r0 * 31) + r5.hashCode();
    L13:
        GenderEnum r6 = r4.getGender();
        if (r6 == null) goto L16;
        r0 = (r0 * 31) + r6.name().hashCode();
    L16:
        List r7 = r4.getCredentialNumbers();
        if (r7 == null) goto L19;
        r0 = (r0 * 31) + r7.hashCode();
    L19:
        List r8 = r4.getEmails();
        if (r8 == null) goto L22;
        r0 = (r0 * 31) + r8.hashCode();
    L22:
        List r9 = r4.getAddresses();
        if (r9 == null) goto L25;
        r0 = (r0 * 31) + r9.hashCode();
    L25:
        String r10 = r4.getCompany();
        if (r10 == null) goto L28;
        r0 = (r0 * 31) + r10.hashCode();
    L28:
        List r11 = r4.getInstantMessagings();
        if (r11 == null) goto L31;
        r0 = (r0 * 31) + r11.hashCode();
    L31:
        List r12 = r4.getAnniversaries();
        if (r12 == null) goto L34;
        r0 = (r0 * 31) + r12.hashCode();
    L34:
        String r13 = r4.getVoip();
        if (r13 == null) goto L37;
        r0 = (r0 * 31) + r13.hashCode();
    L37:
        List r14 = r4.getRelationShips();
        if (r14 == null) goto L40;
        r0 = (r0 * 31) + r14.hashCode();
    L40:
        String r15 = r4.getJobTitle();
        if (r15 == null) goto L43;
        r0 = (r0 * 31) + r15.hashCode();
    L43:
        String r16 = r4.getDepartment();
        if (r16 == null) goto L46;
        r0 = (r0 * 31) + r16.hashCode();
    L46:
        String r17 = r4.getSubNote();
        if (r17 == null) goto L49;
        r0 = (r0 * 31) + r17.hashCode();
    L49:
        List r18 = r4.getWebsites();
        if (r18 != null) goto L52;
        return r0;
    L52:
        return (r0 * 31) + r18.hashCode();
    L54:
        throw new IllegalStateException("Check failed.".toString());
    }
}
