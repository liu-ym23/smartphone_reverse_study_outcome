package com.obric.memorydata.datatransport.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bá\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u00107\u001a\u000208H\u0016J\u0012\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010\u0003J\b\u0010<\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010#R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001e\"\u0004\b%\u0010#R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010(R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010(R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010(R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010#R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010(R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010(R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010#R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010(¨\u0006="}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedContactEntity;", "Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", ActivityLifecycle.NAME, "telephones", "", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "note", "gender", "credentialNumbers", "Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "emails", "Lcom/obric/capabilitykit/entity/meta/MetaEmailAddress;", "addresses", "Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "company", "instantMessagings", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "anniversaries", "Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "voip", "relationShips", "Lcom/obric/capabilitykit/entity/meta/MetaRelationship;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTelephones", "()Ljava/util/List;", "getNote", "setNote", "(Ljava/lang/String;)V", "getGender", "setGender", "getCredentialNumbers", "setCredentialNumbers", "(Ljava/util/List;)V", "getEmails", "setEmails", "getAddresses", "setAddresses", "getCompany", "setCompany", "getInstantMessagings", "setInstantMessagings", "getAnniversaries", "setAnniversaries", "getVoip", "setVoip", "getRelationShips", "setRelationShips", "toOriginalAppEntity", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "mapStringToGenderEnum", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", TypedValues.Custom.S_STRING, "generateEvaluationId", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9719b;
    private final List<MetaTelephone> c;
    private String d;
    private String e;
    private List<MetaCredentialNumber> f;
    private List<MetaEmailAddress> g;
    private List<MetaAddress> h;
    private String i;
    private List<MetaInstantMessaging> j;
    private List<MetaAnniversary> k;
    private String l;
    private List<MetaRelationship> m;

    public final GenderEnum a(String r1) {
        if (Intrinsics.areEqual(r1, "男") == false) goto L6;
        return GenderEnum.MALE;
    L6:
        if (Intrinsics.areEqual(r1, "女") == true) goto L11;
        return null;
    L11:
        return GenderEnum.FEMALE;
    }

    @Override // com.obric.memorydata.datatransport.a.a
    public /* synthetic */ AppEntity d() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(e(), AppEntity.class, "com.obric.memorydata.plugin");
    }

    public ContactEntity e() {
        String r0 = a();
        if (r0 != null) goto L5;
        r0 = "0";
    L5:
        String r1 = r0;
        Long r2 = b();
        long r3 = 0;
        if (r2 == null) goto L8;
        long r4 = r2.longValue();
    L9:
        Long r5 = c();
        if (r5 == null) goto L12;
        r3 = r5.longValue();
    L12:
        ContactEntity r8 = new ContactEntity(r1, r4, r3, this.f9719b, this.c);
        r8.setNote(this.d);
        r8.setGender(a(this.e));
        r8.setCredentialNumbers(this.f);
        r8.setEmails(this.g);
        r8.setAddresses(this.h);
        r8.setCompany(this.i);
        r8.setInstantMessagings(this.j);
        r8.setAnniversaries(this.k);
        r8.setVoip(this.l);
        r8.setRelationShips(this.m);
        return r8;
    L8:
        r4 = 0;
        goto L9
    }
}
