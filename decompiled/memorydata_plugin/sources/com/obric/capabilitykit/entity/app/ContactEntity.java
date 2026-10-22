package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B7\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\b\u0010\\\u001a\u00020]H\u0016J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\rH\u0016J\"\u0010`\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020eH\u0016J\u0018\u0010f\u001a\u00020a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010g\u001a\u00020eH\u0016R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\"\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0013\"\u0004\b9\u0010\u0015R\u001c\u0010:\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\"\"\u0004\b<\u0010$R\u001c\u0010=\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\"\"\u0004\bI\u0010$R\u001c\u0010J\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\"\"\u0004\bL\u0010$R\"\u0010M\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R\u001c\u0010Q\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\"\"\u0004\bS\u0010$R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0013\"\u0004\bU\u0010\u0015R\u001c\u0010V\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\"\"\u0004\bX\u0010$R\"\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015¨\u0006i"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", ActivityLifecycle.NAME, "telephones", "", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "(Ljava/lang/String;JJLjava/lang/String;Ljava/util/List;)V", "addresses", "Lcom/obric/capabilitykit/entity/meta/MetaAddress;", "getAddresses", "()Ljava/util/List;", "setAddresses", "(Ljava/util/List;)V", "anniversaries", "Lcom/obric/capabilitykit/entity/meta/MetaAnniversary;", "getAnniversaries", "setAnniversaries", "avatar", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAvatar", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setAvatar", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "company", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "credentialNumbers", "Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "getCredentialNumbers", "setCredentialNumbers", "department", "getDepartment", "setDepartment", "emails", "Lcom/obric/capabilitykit/entity/meta/MetaEmailAddress;", "getEmails", "setEmails", "gender", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "getGender", "()Lcom/obric/capabilitykit/entity/enums/GenderEnum;", "setGender", "(Lcom/obric/capabilitykit/entity/enums/GenderEnum;)V", "instantMessagings", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "getInstantMessagings", "setInstantMessagings", "jobTitle", "getJobTitle", "setJobTitle", "lastUsedTelephone", "getLastUsedTelephone", "()Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "setLastUsedTelephone", "(Lcom/obric/capabilitykit/entity/meta/MetaTelephone;)V", "lastUsedTelephoneTimeStamp", "getLastUsedTelephoneTimeStamp", "()Ljava/lang/Long;", "setLastUsedTelephoneTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "setName", "note", "getNote", "setNote", "relationShips", "Lcom/obric/capabilitykit/entity/meta/MetaRelationship;", "getRelationShips", "setRelationShips", "subNote", "getSubNote", "setSubNote", "getTelephones", "setTelephones", "voip", "getVoip", "setVoip", "websites", "getWebsites", "setWebsites", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 1;
    private List<MetaAddress> addresses;
    private List<MetaAnniversary> anniversaries;
    private FileEntity avatar;
    private String company;
    private List<MetaCredentialNumber> credentialNumbers;
    private String department;
    private List<MetaEmailAddress> emails;
    private GenderEnum gender;
    private List<MetaInstantMessaging> instantMessagings;
    private String jobTitle;
    private MetaTelephone lastUsedTelephone;
    private Long lastUsedTelephoneTimeStamp;
    private String name;
    private String note;
    private List<MetaRelationship> relationShips;
    private String subNote;
    private List<MetaTelephone> telephones;
    private String voip;
    private List<String> websites;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ContactEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ContactEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<ContactEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
            return (ContactEntity) ZeusTransformUtils.preCheckCast(r1, ContactEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 7;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ContactEntity[] newArray(int r1) {
            return new ContactEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<MetaTelephone, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7542a = null;

        static {
            f7542a = new a();
        }

        public a() {
            super(1);
        }

        public final CharSequence a(MetaTelephone r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
            return r1.getTelephone();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CharSequence invoke(MetaTelephone r3) {
            return a((MetaTelephone) ZeusTransformUtils.preCheckCast(r3, MetaTelephone.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ContactEntity(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(EntityExtKt.readStringOrEmpty(r10), r10.readLong(), r10.readLong(), EntityExtKt.readStringOrEmpty(r10), r10.createTypedArrayList(MetaTelephone.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r0 = r10.readInt();
        this.avatar = (FileEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.memorydata.plugin");
        this.note = r10.readString();
        this.gender = GenderEnum.Companion.from(r10.readString());
        this.credentialNumbers = r10.createTypedArrayList(MetaCredentialNumber.CREATOR);
        this.emails = r10.createTypedArrayList(MetaEmailAddress.CREATOR);
        this.addresses = r10.createTypedArrayList(MetaAddress.CREATOR);
        this.company = r10.readString();
        this.instantMessagings = r10.createTypedArrayList(MetaInstantMessaging.CREATOR);
        this.anniversaries = r10.createTypedArrayList(MetaAnniversary.CREATOR);
        this.voip = r10.readString();
        this.relationShips = r10.createTypedArrayList(MetaRelationship.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 6, r0);
    }

    public ContactEntity(String r9, long r10, long r12, String r14, List<MetaTelephone> r15) {
        List<MetaTelephone> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r14, ActivityLifecycle.NAME);
        super(r9, r10, r12, 201);
        this.name = r14;
        this.telephones = r16;
    }

    public /* synthetic */ ContactEntity(String r10, long r11, long r13, String r15, List r16, int r17, DefaultConstructorMarker r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        if ((r17 & 16) == 0) goto L5;
        r0 = null;
    L5:
        this(r10, r11, r13, r15, r0);
    }

    public final List<MetaAddress> getAddresses() {
        return this.addresses;
    }

    public final List<MetaAnniversary> getAnniversaries() {
        return this.anniversaries;
    }

    public final FileEntity getAvatar() {
        return this.avatar;
    }

    public final String getCompany() {
        return this.company;
    }

    public final List<MetaCredentialNumber> getCredentialNumbers() {
        return this.credentialNumbers;
    }

    public final String getDepartment() {
        return this.department;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<MetaTelephone> r0 = this.telephones;
        Uri r9 = null;
        if (r0 == null) goto L5;
        String r4 = CollectionsKt.joinToString$default(r0, "\n", null, null, 0, null, a.f7542a, 30, null);
    L6:
        FileEntity r1 = this.avatar;
        if (r1 == null) goto L10;
        r9 = r1.getContentUrl();
    L10:
        return new DisplayRepresentation(r9, this.name, r4, getLastModifiedTime());
    L5:
        r4 = null;
        goto L6
    }

    public final List<MetaEmailAddress> getEmails() {
        return this.emails;
    }

    public final GenderEnum getGender() {
        return this.gender;
    }

    public final List<MetaInstantMessaging> getInstantMessagings() {
        return this.instantMessagings;
    }

    public final String getJobTitle() {
        return this.jobTitle;
    }

    public final MetaTelephone getLastUsedTelephone() {
        return this.lastUsedTelephone;
    }

    public final Long getLastUsedTelephoneTimeStamp() {
        return this.lastUsedTelephoneTimeStamp;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNote() {
        return this.note;
    }

    public final List<MetaRelationship> getRelationShips() {
        return this.relationShips;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = this.avatar;
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    public final String getSubNote() {
        return this.subNote;
    }

    public final List<MetaTelephone> getTelephones() {
        return this.telephones;
    }

    public final String getVoip() {
        return this.voip;
    }

    public final List<String> getWebsites() {
        return this.websites;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        switch(r4) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        this.lastUsedTelephoneTimeStamp = (Long) ZeusTransformUtils.preCheckCast(r2.readValue(r3), Long.class, "com.obric.memorydata.plugin");
        return;
    L6:
        this.lastUsedTelephone = (MetaTelephone) ZeusTransformUtils.preCheckCast(r2.readValue(r3), MetaTelephone.class, "com.obric.memorydata.plugin");
        return;
    L7:
        this.websites = (List) ZeusTransformUtils.preCheckCast(r2.readValue(r3), List.class, "com.obric.memorydata.plugin");
        return;
    L8:
        this.subNote = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.memorydata.plugin");
        return;
    L9:
        this.department = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.memorydata.plugin");
        return;
    L10:
        this.jobTitle = (String) ZeusTransformUtils.preCheckCast(r2.readValue(r3), String.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setAddresses(List<MetaAddress> r3) {
        this.addresses = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setAnniversaries(List<MetaAnniversary> r3) {
        this.anniversaries = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setAvatar(FileEntity r1) {
        this.avatar = r1;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final void setCredentialNumbers(List<MetaCredentialNumber> r3) {
        this.credentialNumbers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setDepartment(String r1) {
        this.department = r1;
    }

    public final void setEmails(List<MetaEmailAddress> r3) {
        this.emails = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setGender(GenderEnum r1) {
        this.gender = r1;
    }

    public final void setInstantMessagings(List<MetaInstantMessaging> r3) {
        this.instantMessagings = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setJobTitle(String r1) {
        this.jobTitle = r1;
    }

    public final void setLastUsedTelephone(MetaTelephone r1) {
        this.lastUsedTelephone = r1;
    }

    public final void setLastUsedTelephoneTimeStamp(Long r1) {
        this.lastUsedTelephoneTimeStamp = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setNote(String r1) {
        this.note = r1;
    }

    public final void setRelationShips(List<MetaRelationship> r3) {
        this.relationShips = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setSubNote(String r1) {
        this.subNote = r1;
    }

    public final void setTelephones(List<MetaTelephone> r3) {
        this.telephones = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setVoip(String r1) {
        this.voip = r1;
    }

    public final void setWebsites(List<String> r3) {
        this.websites = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeTypedList(this.telephones);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(6);
        r2.writeParcelable(this.avatar, r3);
        r2.writeString(this.note);
        GenderEnum r4 = this.gender;
        if (r4 == null) goto L5;
        String r5 = r4.name();
    L6:
        r2.writeString(r5);
        r2.writeTypedList(this.credentialNumbers);
        r2.writeTypedList(this.emails);
        r2.writeTypedList(this.addresses);
        r2.writeString(this.company);
        r2.writeTypedList(this.instantMessagings);
        r2.writeTypedList(this.anniversaries);
        r2.writeString(this.voip);
        r2.writeTypedList(this.relationShips);
        r2.writeValue(this.jobTitle);
        r2.writeValue(this.department);
        r2.writeValue(this.subNote);
        r2.writeValue(this.websites);
        r2.writeValue(this.lastUsedTelephone);
        r2.writeValue(this.lastUsedTelephoneTimeStamp);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
