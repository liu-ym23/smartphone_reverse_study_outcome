package com.obric.contactsdk.loader;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.middleware.api.settings.IRecommendSettings;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a,\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f\u001a\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000b2\u0006\u0010\r\u001a\u00020\u000e\u001a4\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f\u001a\u0010\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a,\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010 \u001a\u00020\u001f¨\u0006("}, d2 = {"addressTypeToDesc", "", "cursor", "Landroid/database/Cursor;", "cardTypeToDesc", "dateTypeToDesc", "emailTypeToDesc", "genderTypeToDesc", "Lcom/obric/capabilitykit/entity/enums/GenderEnum;", EventBody.KEY_VALUE, "getAllContactIds", "", "", "context", "Landroid/content/Context;", "getAllIds", "uri", "Landroid/net/Uri;", "getContactIdByPhoneNumber", "contentResolver", "Landroid/content/ContentResolver;", "phoneNumber", "getProfileContactsId", "ids", "getProfileId", "imTypeToDesc", "phoneTypeToDesc", "queryContactById", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", OaidModel.KEY_ID, "isProfile", "", "isRawId", "queryContactSampleEntities", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryContactsByIds", "relationShipsTypeToDesc", "updateContactsListEntitiesQueryByIds", "contactHistoryEntities", "updateRawId2ContactsIdIdsList", "contactsdk_debug"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class e {
    public static final GenderEnum a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r2, "1") == false) goto L9;
        return GenderEnum.MALE;
    L9:
        if (Intrinsics.areEqual(r2, "2") == true) goto L11;
        return null;
    L11:
        return GenderEnum.FEMALE;
    }

    public static final String a(ContentResolver r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Intrinsics.checkNotNullParameter(r11, "phoneNumber");
        Uri r3 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(r11));
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedPath(...)");
        String r1 = null;
        Cursor r12 = ZeusProviderTransform.query(r10, r3, new String[]{"_id"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r12 != null) goto L52;
    L25:
        if (r12 == null) goto L54;
        r12.close();
        return r1;
    L54:
        return r1;
    L52:
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r12.moveToFirst() == false) goto L10;
        String r13 = d.a(r12, "_id");     // Catch: Throwable -> L18
    L42:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L14
        r1 = r13;
    L14:
        Object th = th;
    L44:
        Log.d("ContactEntityUtilKt", "getContactIdByPhoneNumber err = " + th);     // Catch: Throwable -> L35
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L34;
        r14.close();
    L34:
        return r13;
    L35:
        th = move-exception;
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L39;
        r15.close();
    L39:
        throw th;
    L16:
        th = move-exception;
        r1 = r13;
        th = th;
    L48:
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L10:
        r13 = null;
    L18:
        th = th;
    L23:
        th = move-exception;
        String r9 = r1;
        th = th;
        r13 = r9;
    L27:
        th = move-exception;
        r13 = null;
        th = th;
        r12 = null;
        goto L44
    }

    public static final String a(Context r12, List<Long> r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "ids");
        Cursor r16 = ZeusProviderTransform.query(r14.getContentResolver(), ContactsContract.Profile.CONTENT_URI, new String[]{"_id"}, "name_raw_contact_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L25
        if (r16 == null) goto L27;
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.memorydata.plugin");     // Catch: SecurityException -> L25
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r2.moveToFirst() == true) goto L10;
        CloseableKt.closeFinally(r17, null);     // Catch: SecurityException -> L25
        return null;
    L10:
        long r3 = r2.getLong(r2.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L20
        if (r15.contains(Long.valueOf(r3)) == true) goto L12;
        if (r2.moveToNext() == true) goto L10;
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r17, null);     // Catch: SecurityException -> L25
        goto L27
    L12:
        String r19 = String.valueOf(r3);     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r17, null);     // Catch: SecurityException -> L25
        return r19;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: SecurityException -> L25
        throw th;     // Catch: SecurityException -> L25
    L27:
        return null;
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    public static final String a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r4 = r3.getString(r3.getColumnIndexOrThrow("data2"));
        if (r4 != null) goto L5;
    L19:
        return null;
    L5:
        switch(r4.hashCode()) {
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L19;
        };
    L8:
        if (r4.equals("3") == false) goto L19;
        return "驾驶证";
    L12:
        if (r4.equals("2") == false) goto L19;
        return "银行卡";
    L16:
        if (r4.equals("1") == false) goto L19;
        return "身份证";
    }

    public static final List<Long> a(ContentResolver r11, List<Long> r12, boolean r13) {
        List<Long> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        Intrinsics.checkNotNullParameter(r14, "ids");
        if (r13 == true) goto L5;
        return r14;
    L5:
        Cursor r15 = ZeusProviderTransform.query(r11, ContactsContract.RawContacts.CONTENT_URI, new String[]{"contact_id"}, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        List<Long> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L21;
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L10:
        if (r1.moveToNext() == false) goto L14;
        long r2 = r1.getLong(r1.getColumnIndexOrThrow("contact_id"));     // Catch: Throwable -> L16
        if (r16.contains(Long.valueOf(r2)) == true) goto L10;
        r16.add(Long.valueOf(r2));     // Catch: Throwable -> L16
        goto L10
    L14:
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r17, null);
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);
        throw th;
    L21:
        return r16;
    }

    public static final List<ContactEntity> a(ContentResolver r31, List<Long> r32, boolean r33, boolean r34) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r31, "contentResolver");
        Intrinsics.checkNotNullParameter(r1, "ids");
        List<Long> r9 = a(r31, r1, r34);
        com.obric.a.a.f.f5867a.a("ContactEntityUtilKt", "queryContactsByIds ids size: " + r1.size() + ", updatedIds size: " + r9.size());
        String r11 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
        Map r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        String r4 = "_id IN " + r11;
        if (r33 == false) goto L5;
        Uri r2 = ContactsContract.Profile.CONTENT_URI;
    L6:
        String r0 = "contact_last_updated_timestamp";
        Cursor r3 = ZeusProviderTransform.query(r31, r2, new String[]{"_id", "photo_uri", "lookup", "contact_last_updated_timestamp"}, r4, null, null, "com.obric.memorydata.plugin");
        if (r3 == null) goto L25;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r3, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r6 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L11:
        if (r6.moveToNext() == false) goto L17;
        long r7 = r6.getLong(r6.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L19
        String r22 = r6.getString(r6.getColumnIndexOrThrow("photo_uri"));     // Catch: Throwable -> L19
        String r8 = r6.getString(r6.getColumnIndexOrThrow("lookup"));     // Catch: Throwable -> L19
        long r28 = r6.getLong(r6.getColumnIndexOrThrow(r0));     // Catch: Throwable -> L19
        if (r22 == null) goto L15;
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L19
        Uri r10 = Uri.parse(r22);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r10, "parse(...)");     // Catch: Throwable -> L19
        FileEntity r13 = new FileEntity(r22, 0, 0, r22, 0, r10, FileTypeEnum.FILE, "image/jpeg");     // Catch: Throwable -> L19
    L16:
        Uri r18 = ContactsContract.Contacts.getLookupUri(r7, r8);     // Catch: Throwable -> L19
        ContactEntity r14 = new ContactEntity(String.valueOf(r7), r28, r28, "", null);     // Catch: Throwable -> L19
        r14.setAvatar(r13);     // Catch: Throwable -> L19
        r14.addExtraEntity(new ExtraEntity(ExtraEntity.KEY_EXTRA_1, r18, false, 4, null));     // Catch: Throwable -> L19
        r12.put(Long.valueOf(r7), r14);     // Catch: Throwable -> L19
        r0 = r0;
        goto L11
    L15:
        r13 = null;
        goto L16
    L17:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Throwable r16 = null;
        CloseableKt.closeFinally(r5, null);
    L26:
        String r17 = "contact_id IN " + r11;
        if (r33 == false) goto L29;
        Cursor r19 = ZeusProviderTransform.query(r31, Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data"), f.a(), null, null, null, "com.obric.memorydata.plugin");
    L30:
        if (r19 == null) goto L136;
        Closeable r20 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r21 = (Cursor) ZeusTransformUtils.preCheckCast(r20, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L130
    L34:
        if (r21.moveToNext() == false) goto L128;
        ContactEntity r23 = (ContactEntity) ZeusTransformUtils.preCheckCast(r12.get(Long.valueOf(r21.getLong(r21.getColumnIndexOrThrow("contact_id")))), ContactEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L130
        String r24 = r21.getString(r21.getColumnIndexOrThrow("mimetype"));     // Catch: Throwable -> L130
        String r25 = r21.getString(r21.getColumnIndexOrThrow("data1"));     // Catch: Throwable -> L130
        if (r25 == null) goto L34;
        if (r23 == null) goto L34;
        if (r24 == null) goto L34;
        String r110 = "";
        switch(r24.hashCode()) {
            case -1569536764: goto L122;
            case -1328682538: goto L111;
            case -1079224304: goto L107;
            case -1079210633: goto L103;
            case -601229436: goto L96;
            case -213986043: goto L85;
            case 3430506: goto L81;
            case 684173810: goto L74;
            case 689862072: goto L70;
            case 950831081: goto L59;
            case 1409846529: goto L48;
            case 2050851590: goto L44;
            default: goto L34;
        };
    L44:
        if (r24.equals("vnd.android.cursor.item/gender") == false) goto L34;
        r23.setGender(a(r25));     // Catch: Throwable -> L130
        goto L34
    L48:
        if (r24.equals("vnd.android.cursor.item/relation") == false) goto L34;
        List<MetaRelationship> r26 = r23.getRelationShips();     // Catch: Throwable -> L130
        if (r26 != null) goto L53;
        r26 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L53:
        List<MetaRelationship> r27 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r26, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        String r111 = f(r19);     // Catch: Throwable -> L130
        if (r111 == null) goto L57;
        r110 = r111;
    L57:
        r27.add(new MetaRelationship(r110, r25));     // Catch: Throwable -> L130
        r23.setRelationShips(r27);     // Catch: Throwable -> L130
        goto L34
    L59:
        if (r24.equals("vnd.android.cursor.item/im") == false) goto L34;
        List<MetaInstantMessaging> r29 = r23.getInstantMessagings();     // Catch: Throwable -> L130
        if (r29 != null) goto L64;
        r29 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L64:
        List<MetaInstantMessaging> r30 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r29, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        String r112 = e(r19);     // Catch: Throwable -> L130
        if (r112 == null) goto L68;
        r110 = r112;
    L68:
        r30.add(new MetaInstantMessaging(r110, r25));     // Catch: Throwable -> L130
        r23.setInstantMessagings(r30);     // Catch: Throwable -> L130
        goto L34
    L70:
        if (r24.equals("vnd.android.cursor.item/organization") == false) goto L34;
        r23.setCompany(r25);     // Catch: Throwable -> L130
        goto L34
    L74:
        if (r24.equals("vnd.android.cursor.item/phone_v2") == false) goto L34;
        List<MetaTelephone> r35 = r23.getTelephones();     // Catch: Throwable -> L130
        if (r35 != null) goto L79;
        r35 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L79:
        List<MetaTelephone> r36 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        r36.add(new MetaTelephone(r25, c(r19)));     // Catch: Throwable -> L130
        r23.setTelephones(r36);     // Catch: Throwable -> L130
        goto L34
    L81:
        if (r24.equals("vnd.android.cursor.item/sip_address") == false) goto L34;
        r23.setVoip(r25);     // Catch: Throwable -> L130
        goto L34
    L85:
        if (r24.equals("vnd.android.cursor.item/card_id") == false) goto L34;
        List<MetaCredentialNumber> r37 = r23.getCredentialNumbers();     // Catch: Throwable -> L130
        if (r37 != null) goto L90;
        r37 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L90:
        List<MetaCredentialNumber> r38 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r37, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        String r113 = a(r19);     // Catch: Throwable -> L130
        if (r113 == null) goto L94;
        r110 = r113;
    L94:
        r38.add(new MetaCredentialNumber(r25, r110));     // Catch: Throwable -> L130
        r23.setCredentialNumbers(r38);     // Catch: Throwable -> L130
        goto L34
    L96:
        if (r24.equals("vnd.android.cursor.item/postal-address_v2") == false) goto L34;
        List<MetaAddress> r39 = r23.getAddresses();     // Catch: Throwable -> L130
        if (r39 != null) goto L101;
        r39 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L101:
        List<MetaAddress> r40 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r39, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        r40.add(new MetaAddress(r25, d(r19)));     // Catch: Throwable -> L130
        r23.setAddresses(r40);     // Catch: Throwable -> L130
        goto L34
    L103:
        if (r24.equals("vnd.android.cursor.item/note") == false) goto L34;
        r23.setNote(r25);     // Catch: Throwable -> L130
        goto L34
    L107:
        if (r24.equals("vnd.android.cursor.item/name") == false) goto L34;
        r23.setName(r25);     // Catch: Throwable -> L130
        goto L34
    L111:
        if (r24.equals("vnd.android.cursor.item/contact_event") == false) goto L34;
        List<MetaAnniversary> r41 = r23.getAnniversaries();     // Catch: Throwable -> L130
        if (r41 != null) goto L116;
        r41 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L116:
        List<MetaAnniversary> r42 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r41, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        String r114 = g(r19);     // Catch: Throwable -> L130
        if (r114 == null) goto L120;
        r110 = r114;
    L120:
        r42.add(new MetaAnniversary(r110, r25));     // Catch: Throwable -> L130
        r23.setAnniversaries(r42);     // Catch: Throwable -> L130
        goto L34
    L122:
        if (r24.equals("vnd.android.cursor.item/email_v2") == false) goto L34;
        List<MetaEmailAddress> r43 = r23.getEmails();     // Catch: Throwable -> L130
        if (r43 != null) goto L127;
        r43 = CollectionsKt.emptyList();     // Catch: Throwable -> L130
    L127:
        List<MetaEmailAddress> r44 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r43, Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L130
        r44.add(new MetaEmailAddress(r25, b(r19)));     // Catch: Throwable -> L130
        r23.setEmails(r44);     // Catch: Throwable -> L130
        goto L34
    L128:
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L130
        CloseableKt.closeFinally(r20, r16);
    L130:
        th = move-exception;
        throw th;     // Catch: Throwable -> L133
    L133:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);
        throw th;
    L136:
        List<ContactEntity> r46 = a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r12.values(), Iterable.class, "com.obric.memorydata.plugin")), r9);
        com.obric.a.a.f.f5867a.a("ContactEntityUtilKt", "queryContactsByIds return list size: " + r46.size());
        return r46;
    L29:
        r19 = ZeusProviderTransform.query(r31, ContactsContract.Data.CONTENT_URI, f.a(), r17, null, null, "com.obric.memorydata.plugin");
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L25:
        r16 = null;
        goto L26
    L5:
        r2 = ContactsContract.Contacts.CONTENT_URI;
        goto L6
    }

    public static final List<Long> a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Uri r0 = ContactsContract.Contacts.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r0, "CONTENT_URI");
        return a(r3, r0);
    }

    public static final List<Long> a(Context r9, Uri r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r10, "uri");
        List<Long> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Cursor r12 = ZeusProviderTransform.query(r11.getContentResolver(), r10, new String[]{"_id"}, null, null, null, "com.obric.memorydata.plugin");
        if (r12 == null) goto L18;
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r2, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L7:
        if (r12.moveToNext() == false) goto L11;
        int r3 = r12.getColumnIndex("_id");     // Catch: Throwable -> L13
        if (r3 == (-1)) goto L7;
        r0.add(Long.valueOf(r12.getLong(r3)));     // Catch: Throwable -> L13
        goto L7
    L11:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r2, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    L18:
        return r0;
    }

    public static final List<ContactEntity> a(List<ContactEntity> r9, List<Long> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "contactHistoryEntities");
        Intrinsics.checkNotNullParameter(r12, "ids");
        List<ContactEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r13.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterator r4 = r11.iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        ContactEntity r5 = (ContactEntity) ZeusTransformUtils.preCheckCast(r4.next(), ContactEntity.class, "com.obric.memorydata.plugin");
        if (TextUtils.equals((CharSequence) ZeusTransformUtils.preCheckCast(String.valueOf(r2), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r5.getId(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        if (r0.contains(r5) == true) goto L7;
        r0.add(r5);
        goto L7
    L13:
        return r0;
    }

    public static final String b(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow("data2"));
        if (r0 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("3") == false) goto L23;
        return IRecommendSettings.ProfileTag.OTHER;
    L12:
        if (r0.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r0.equals("1") == false) goto L23;
        return "个人";
    L20:
        if (r0.equals("0") == false) goto L23;
        return r3.getString(r3.getColumnIndexOrThrow("data3"));
    }

    public static final List<EntityIdData> b(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "context");
        List<EntityIdData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        Cursor r2 = ZeusProviderTransform.query(r11.getContentResolver(), r3, new String[]{"_id", "contact_last_updated_timestamp"}, null, null, null, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        int r12 = r1.getColumnIndex("_id");     // Catch: Throwable -> L13
        int r5 = r1.getColumnIndex("contact_last_updated_timestamp");     // Catch: Throwable -> L13
        if (r12 == (-1)) goto L11;
        if (r5 == (-1)) goto L11;
    L9:
        if (r1.moveToNext() == false) goto L11;
        long r6 = r1.getLong(r12);     // Catch: Throwable -> L13
        long r7 = r1.getLong(r5);     // Catch: Throwable -> L13
        r0.add(new EntityIdData(String.valueOf(r6), 201, r7));     // Catch: Throwable -> L13
    L11:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r4, null);
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L18:
        return r0;
    }

    public static final String c(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "cursor");
        String r0 = r4.getString(r4.getColumnIndexOrThrow("data2"));
        if (r0 == null) goto L32;
        int r1 = r0.hashCode();
        if (r1 == 55) goto L29;
        switch(r1) {
            case 48: goto L25;
            case 49: goto L21;
            case 50: goto L17;
            case 51: goto L13;
            case 52: goto L9;
            default: goto L32;
        };
    L9:
        if (r0.equals("4") == false) goto L32;
        return "传真";
    L13:
        if (r0.equals("3") == false) goto L32;
        return "工作";
    L17:
        if (r0.equals("2") == false) goto L32;
        return "电话";
    L21:
        if (r0.equals("1") == false) goto L32;
        return "住宅";
    L25:
        if (r0.equals("0") == false) goto L32;
        return r4.getString(r4.getColumnIndexOrThrow("data3"));
    L29:
        if (r0.equals("7") == false) goto L32;
        return IRecommendSettings.ProfileTag.OTHER;
    L32:
        return null;
    }

    public static final List<Long> c(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Uri r0 = ContactsContract.Profile.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r0, "CONTENT_URI");
        return a(r3, r0);
    }

    public static final String d(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow("data2"));
        if (r0 != null) goto L5;
    L23:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L20;
            case 49: goto L16;
            case 50: goto L12;
            case 51: goto L8;
            default: goto L23;
        };
    L8:
        if (r0.equals("3") == false) goto L23;
        return IRecommendSettings.ProfileTag.OTHER;
    L12:
        if (r0.equals("2") == false) goto L23;
        return "工作";
    L16:
        if (r0.equals("1") == false) goto L23;
        return "住宅";
    L20:
        if (r0.equals("0") == false) goto L23;
        return r3.getString(r3.getColumnIndexOrThrow("data3"));
    }

    public static final String e(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "cursor");
        String r0 = r4.getString(r4.getColumnIndexOrThrow("data5"));
        if (r0 == null) goto L42;
        int r1 = r0.hashCode();
        if (r1 == 49) goto L39;
        if (r1 == 1444) goto L35;
        if (r1 == 51) goto L31;
        if (r1 == 52) goto L27;
        switch(r1) {
            case 48625: goto L23;
            case 48626: goto L19;
            case 48627: goto L15;
            default: goto L42;
        };
    L15:
        if (r0.equals(BDLocationException.ERROR_UID_IS_EMPTY) == false) goto L42;
        return "旺旺";
    L19:
        if (r0.equals("101") == false) goto L42;
        return "陌陌";
    L23:
        if (r0.equals(BDLocationException.ERROR_BEACON_ADVERTISING) == false) goto L42;
        return "微信";
    L27:
        if (r0.equals("4") == false) goto L42;
        return "QQ";
    L31:
        if (r0.equals("3") == false) goto L42;
        return "SKYPE";
    L35:
        if (r0.equals(StructuredDataId.RESERVED) == false) goto L42;
        return r4.getString(r4.getColumnIndexOrThrow("data6"));
    L39:
        if (r0.equals("1") == false) goto L42;
        return "MSN";
    L42:
        return null;
    }

    public static final String f(Cursor r3) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "cursor");
        String r0 = r4.getString(r4.getColumnIndexOrThrow("data2"));
        if (r0 == null) goto L43;
        int r1 = r0.hashCode();
        if (r1 == 48) goto L40;
        if (r1 == 1567) goto L37;
        if (r1 == 1569) goto L33;
        if (r1 == 54) goto L29;
        if (r1 == 55) goto L25;
        switch(r1) {
            case 48625: goto L21;
            case 48626: goto L17;
            default: goto L43;
        };
    L17:
        if (r0.equals("101") == false) goto L43;
        return "同学";
    L21:
        if (r0.equals(BDLocationException.ERROR_BEACON_ADVERTISING) == false) goto L43;
        return "同事";
    L25:
        if (r0.equals("7") == false) goto L43;
        return "领导";
    L29:
        if (r0.equals("6") == false) goto L43;
        return "朋友";
    L33:
        if (r0.equals("12") == false) goto L43;
        return "亲属";
    L37:
        if (r0.equals("10") == false) goto L43;
        return "合作伙伴";
    L40:
        if (r0.equals("0") == false) goto L43;
        return r4.getString(r4.getColumnIndexOrThrow("data3"));
    L43:
        return null;
    }

    public static final String g(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        String r0 = r3.getString(r3.getColumnIndexOrThrow("data2"));
        if (r0 != null) goto L5;
    L27:
        return null;
    L5:
        switch(r0.hashCode()) {
            case 48: goto L24;
            case 49: goto L20;
            case 50: goto L16;
            case 51: goto L12;
            case 52: goto L8;
            default: goto L27;
        };
    L8:
        if (r0.equals("4") == false) goto L27;
        return "农历生日";
    L12:
        if (r0.equals("3") == false) goto L27;
        return "生日";
    L16:
        if (r0.equals("2") == false) goto L27;
        return IRecommendSettings.ProfileTag.OTHER;
    L20:
        if (r0.equals("1") == false) goto L27;
        return "周年纪念日";
    L24:
        if (r0.equals("0") == false) goto L27;
        return r3.getString(r3.getColumnIndexOrThrow("data3"));
    }
}
