package com.obric.memorydata.personalcontext.external.message;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004?@ABB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J}\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b2 \u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0002¢\u0006\u0002\u0010!J\"\u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001dH\u0002J\"\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001dH\u0002J\u0019\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010)J\"\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u001dH\u0002J%\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\b\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\u0010.J2\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u0005002\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020-2\u0006\u0010\r\u001a\u00020\u000eH\u0002J{\u00104\u001a\u0002052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00106\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\u0006\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\b2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00192&\u0010:\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0;0\u0005\u0012\u0004\u0012\u0002050\u001b¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010>\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "supportDonateTypes", "", "", "TAG", "", "MMS_MESSAGE_TYPE_SEND_REQ", "MMS_MESSAGE_TYPE_RETRIEVE", "onGetAllEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "onGetAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "onQueryEntities", "entityIds", "getDonateEntityTypeList", "queryEntitiesInnerByIds", "uri", "Landroid/net/Uri;", "idDesc", "projection", "", "columnMapProvider", "Lkotlin/Function1;", "Landroid/database/Cursor;", "Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;", "entityProvider", "Lkotlin/Function3;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "(Landroid/content/ContentResolver;Landroid/net/Uri;Ljava/util/List;Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Ljava/util/List;", "createEntityFromSms", "cursor", "columnMap", "createEntityFromMms", "getMessageStatus", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "code", "(Ljava/lang/Integer;)Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "createEntityFromRms", "getPhoneNumberByThreadId", "threadId", "", "(Ljava/lang/Long;Landroid/content/ContentResolver;)Ljava/util/List;", "getMmsPart", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "mmsId", "createTime", "smsMmsPaginationQuery", "", "pageLimit", "projectionColumnName", "selection", "selectionArgs", "result", "", "(Landroid/content/ContentResolver;Landroid/net/Uri;I[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getColumnIndex", "columnName", "ColumnMap", "SmsColumnMap", "MmsColumnMap", "RmsColumnMap", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12148b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;", "", "cursor", "Landroid/database/Cursor;", "<init>", "(Landroid/database/Cursor;)V", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class a {
        public a(Cursor r3) {
            Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.external.message.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$MmsColumnMap;", "Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;", "cursor", "Landroid/database/Cursor;", "<init>", "(Landroid/database/Cursor;)V", "columnMsgId", "", "getColumnMsgId", "()I", "columnDate", "getColumnDate", "columnMessageType", "getColumnMessageType", "columnMessageBox", "getColumnMessageBox", "columnThreadId", "getColumnThreadId", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0654b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12150b;
        private final int c;
        private final int d;
        private final int e;

        public C0654b(Cursor r3) {
            Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            super(r4);
            this.f12149a = b.a(b.f12147a, r4, "_id");
            this.f12150b = b.a(b.f12147a, r4, "date");
            this.c = b.a(b.f12147a, r4, "m_type");
            this.d = b.a(b.f12147a, r4, "msg_box");
            this.e = b.a(b.f12147a, r4, "thread_id");
        }

        public final int a() {
            return this.f12149a;
        }

        public final int b() {
            return this.f12150b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$RmsColumnMap;", "Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;", "cursor", "Landroid/database/Cursor;", "provider", "Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;", "<init>", "(Landroid/database/Cursor;Lcom/obric/memorydata/personalcontext/external/message/IRmsProvider;)V", "columnMsgId", "", "getColumnMsgId", "()I", "columnDate", "getColumnDate", "columnAddress", "getColumnAddress", "columnMessageType", "getColumnMessageType", "columnThreadId", "getColumnThreadId", "columnBody", "getColumnBody", "getAttachments", "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Cursor f12151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e f12152b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;
        private final int h;

        public c(Cursor r3, e r4) {
            Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "provider");
            super(r5);
            this.f12151a = r5;
            this.f12152b = r6;
            this.c = b.a(b.f12147a, r5, r6.b());
            this.d = b.a(b.f12147a, r5, r6.c());
            this.e = b.a(b.f12147a, r5, r6.f());
            this.f = b.a(b.f12147a, r5, r6.h());
            this.g = b.a(b.f12147a, r5, r6.e());
            this.h = b.a(b.f12147a, r5, r6.g());
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.d;
        }

        public final int c() {
            return this.e;
        }

        public final int d() {
            return this.f;
        }

        public final int e() {
            return this.g;
        }

        public final int f() {
            return this.h;
        }

        public final List<FileEntity> g() {
            return this.f12152b.a(this.f12151a);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$SmsColumnMap;", "Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsDataRequester$ColumnMap;", "cursor", "Landroid/database/Cursor;", "<init>", "(Landroid/database/Cursor;)V", "columnMsgId", "", "getColumnMsgId", "()I", "columnAddress", "getColumnAddress", "columnBody", "getColumnBody", "columnDate", "getColumnDate", "columnDateSent", "getColumnDateSent", "columnType", "getColumnType", "columnThreadId", "getColumnThreadId", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12154b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public d(Cursor r3) {
            Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            super(r4);
            this.f12153a = b.a(b.f12147a, r4, "_id");
            this.f12154b = b.a(b.f12147a, r4, MemoryKeyInfoEntity.KEY_ADDRESS);
            this.c = b.a(b.f12147a, r4, "body");
            this.d = b.a(b.f12147a, r4, "date");
            this.e = b.a(b.f12147a, r4, "date_sent");
            this.f = b.a(b.f12147a, r4, "type");
            this.g = b.a(b.f12147a, r4, "thread_id");
        }

        public final int a() {
            return this.f12153a;
        }

        public final int b() {
            return this.f12154b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }
    }

    static {
        f12147a = new b();
        f12148b = CollectionsKt.listOf(101);
    }

    private b() {
    }

    private final int a(Cursor r5, String r6) {
        Cursor r4 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r5, Cursor.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L21;
        return r4.getColumnIndexOrThrow(r6);
    L15:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsDataRequester", "getColumnIndex failed,columnName=" + r6, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return -1;
    L21:
        return -1;
    L7:
        if (r1.length() == 0) goto L10;
        r2 = false;
        goto L11
    L20:
        return -1;
    }

    public static final /* synthetic */ int a(b r2, Cursor r3, String r4) {
        return r2.a((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"), r4);
    }

    private final MessageEntity a(ContentResolver r17, Cursor r18, a r19) {
        Cursor r2 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r18, Cursor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, d.class) == true) goto L5;
        return null;
    L5:
        if (((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).a() == (-1)) goto L29;
        long r4 = r2.getLong(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).a());
        long r11 = r2.getLong(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).d());
        long r6 = r2.getLong(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).e());
        String r8 = r2.getString(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).b());
        if (r8 != null) goto L11;
        r8 = "";
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == false) goto L16;
        List<String> r9 = a(Long.valueOf(r2.getLong(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).g())), r17);
    L17:
        List<String> r13 = r9;
        String r12 = r2.getString(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).c());
        if (r12 != null) goto L20;
        String r14 = "";
    L21:
        MessageStatusTypeEnum r0 = a(Integer.valueOf(r2.getInt(((d) ZeusTransformUtils.preCheckCast(r19, d.class, "com.obric.memorydata.plugin")).f())));
        if (r0 != MessageStatusTypeEnum.DRAFT) goto L24;
        long r15 = r11;
    L25:
        MessageEntity r1 = new MessageEntity(com.obric.memorydata.personalcontext.external.message.a.a(String.valueOf(r4)), r15, r11, r13, r14, null);
        r1.setMessageStatusType(r0);
        return r1;
    L24:
        r15 = r6;
        goto L25
    L20:
        r14 = r12;
        goto L21
    L16:
        String r16 = g.f12138a.c(r8);
        ArrayList r110 = new ArrayList();
        r110.add(r16);
        r9 = (List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin");
        goto L17
    L13:
        r10 = false;
        goto L14
    L29:
        return null;
    }

    public static final /* synthetic */ MessageEntity a(b r2, ContentResolver r3, Cursor r4, a r5) {
        return r2.a(r3, (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
    }

    private final MessageStatusTypeEnum a(Integer r2) {
        if (r2 == null) goto L8;
        if (r2.intValue() != 1) goto L8;
        return MessageStatusTypeEnum.INBOX;
    L8:
        if (r2 == null) goto L14;
        if (r2.intValue() != 2) goto L14;
        return MessageStatusTypeEnum.OUTBOX;
    L14:
        if (r2 == null) goto L20;
        if (r2.intValue() != 3) goto L20;
        return MessageStatusTypeEnum.DRAFT;
    L20:
        if (r2 == null) goto L26;
        if (r2.intValue() != 4) goto L26;
        return MessageStatusTypeEnum.SENDING;
    L26:
        if (r2 != null) goto L29;
    L31:
        return null;
    L29:
        if (r2.intValue() != 5) goto L31;
        return MessageStatusTypeEnum.SEND_FAILED;
    }

    private static final c a(e r2, Cursor r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "cursor");
        return new c(r5, r4);
    }

    private static final d a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        return new d(r3);
    }

    private final List<AppEntity> a(ContentResolver r14, Uri r15, List<String> r16, String r17, String[] r18, Function1<? super Cursor, ? extends a> r19, Function3<? super ContentResolver, ? super Cursor, ? super a, MessageEntity> r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.memorydata.plugin");
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Function3 r3 = (Function3) ZeusTransformUtils.wrapperContextForParams(r20, Function3.class, "com.obric.memorydata.plugin");
        Cursor r1 = ZeusProviderTransform.query(r14, r15, r18, r17 + " IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        ArrayList r4 = new ArrayList();
        if (r1 == null) goto L21;
        Closeable r5 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r5, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        a r6 = (a) ZeusTransformUtils.preCheckCast(r2.invoke(r1), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
    L7:
        if (r7.moveToNext() == false) goto L12;
        MessageEntity r9 = (MessageEntity) ZeusTransformUtils.preCheckCast(r3.invoke(r14, r1, r6), MessageEntity.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r9 == null) goto L7;
        r4.add(r9);     // Catch: Throwable -> L14
        goto L7
    L12:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r5, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);
        throw th;
    L21:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
    }

    private final List<String> a(Long r13, ContentResolver r14) {
        if (r13 == null) goto L75;
        if (r13.longValue() <= 0) goto L75;
        ArrayList r12 = new ArrayList();
        Cursor r15 = ZeusProviderTransform.query(r14, com.obric.memorydata.personalcontext.external.message.a.d(), new String[]{"recipient_ids"}, "_id = " + r13, null, null, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r15 == null) goto L20;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r3 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r3.moveToFirst() == false) goto L12;
        String r4 = r3.getString(0);     // Catch: Throwable -> L15
    L13:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r16, null);
    L21:
        CharSequence r17 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L24;
    L25:
        r0 = true;
    L26:
        if (r0 == true) goto L28;
        if (r4 == null) goto L42;
        List r18 = StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{" "}, false, 0, 6, null);
        if (r18 == null) goto L42;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r110 = r19.iterator();
    L34:
        if (r110.hasNext() == false) goto L41;
        Long r6 = Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin")));     // Catch: NumberFormatException -> L38
    L39:
        if (r6 == null) goto L34;
        r1.add(r6);
    L38:
        r6 = null;
        goto L39
    L41:
        List r111 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L44:
        if (r111.isEmpty() == true) goto L46;
        Cursor r112 = ZeusProviderTransform.query(r14, com.obric.memorydata.personalcontext.external.message.a.e(), new String[]{MemoryKeyInfoEntity.KEY_ADDRESS}, "_id in " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        if (r112 == null) goto L73;
        Closeable r113 = (Closeable) ZeusTransformUtils.preCheckCast(r112, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r113, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L67
        int r114 = r2.getColumnIndex(MemoryKeyInfoEntity.KEY_ADDRESS);     // Catch: Throwable -> L67
        if (r114 != (-1)) goto L56;
        List<String> r115 = CollectionsKt.emptyList();     // Catch: Throwable -> L67
        CloseableKt.closeFinally(r113, null);
        return r115;
    L56:
        if (r2.moveToNext() == false) goto L65;
        String r7 = r2.getString(r114);     // Catch: Throwable -> L67
        String r8 = "";
        if (r7 == null) goto L64;
        String r9 = new Regex("\\s").replace((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), "");     // Catch: Throwable -> L67
        if (r9 == null) goto L64;
        r8 = r9;
    L64:
        r12.add(g.f12138a.c(r8));     // Catch: Throwable -> L67
        goto L56
    L65:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L67
        CloseableKt.closeFinally(r113, null);
    L67:
        th = move-exception;
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);
        throw th;
    L73:
        return (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin");
    L46:
        return CollectionsKt.emptyList();
    L42:
        r111 = CollectionsKt.emptyList();
        goto L44
    L28:
        return CollectionsKt.emptyList();
    L24:
        if (r17.length() != 0) goto L26;
    L12:
        r4 = null;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L20:
        r4 = null;
    L75:
        return CollectionsKt.emptyList();
    }

    private final Pair<String, List<FileEntity>> a(String r24, long r25, ContentResolver r27) {
        Uri r2 = Telephony.Mms.Part.getPartUriForMessage(r24);
        Intrinsics.checkNotNullExpressionValue(r2, "getPartUriForMessage(...)");
        Cursor r0 = ZeusProviderTransform.query(r27, r2, null, null, null, null, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r3 = "";
        if (r0 == null) goto L24;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        b r6 = f12147a;     // Catch: Throwable -> L17
        int r7 = r6.a(r5, "_id");     // Catch: Throwable -> L17
        int r8 = r6.a(r5, "ct");     // Catch: Throwable -> L17
        int r9 = r6.a(r5, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L17
        int r10 = r6.a(r5, "_data");     // Catch: Throwable -> L17
    L7:
        if (r5.moveToNext() == false) goto L15;
        long r11 = r5.getLong(r7);     // Catch: Throwable -> L17
        String r15 = r5.getString(r8);     // Catch: Throwable -> L17
        String r12 = r5.getString(r9);     // Catch: Throwable -> L17
        String r13 = r5.getString(r10);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual("application/smil", r15) == true) goto L7;
        if (r12 != null) goto L12;
        if (r13 == null) goto L7;
        Uri r20 = Telephony.Mms.Part.CONTENT_URI.buildUpon().appendPath(String.valueOf(r11)).build();     // Catch: Throwable -> L17
        String r14 = new File(r13).getName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r14, "getName(...)");     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L17
        r1.add(new FileEntity(r13, r25, r25, r14, 0, r20, FileTypeEnum.FILE, r15));     // Catch: Throwable -> L17
        goto L7
    L12:
        r3 = r12;
        goto L7
    L15:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r4, null);
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L24:
        return TuplesKt.to(r3, r1);
    }

    private static final Unit a(e r6, List r7, List r8) {
        e r9 = (e) ZeusTransformUtils.wrapperContextForParams(r6, e.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "rows");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r12.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(r9.b()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.c(r2);
        if (r3 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get(r9.c()), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r1);
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        r10.add(new EntityIdData(r3, 101, r5));
    L15:
        r5 = 0;
        goto L16
    L18:
        return Unit.INSTANCE;
    }

    private static final Unit a(List r4, e r5, List r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        e r8 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "it");
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin")).get(r8.b()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.c(r2);
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L11:
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit a(List r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin")).get(com.obric.memorydata.personalcontext.external.message.a.i()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.a(r2);
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L11:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final MessageEntity b(ContentResolver r20, Cursor r21, a r22) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r22, C0654b.class) == true) goto L5;
    L14:
        return null;
    L5:
        if (((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).a() == (-1)) goto L14;
        String r5 = String.valueOf(r3.getLong(((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).a()));
        int r7 = r3.getInt(((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).c());
        if (r7 != 132) goto L10;
    L12:
        long r14 = r3.getLong(((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).b()) * 1000;
        List<String> r16 = a(Long.valueOf(r3.getLong(((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).e())), r20);
        Pair<String, List<FileEntity>> r1 = a(r5, r14, r20);
        String r17 = (String) ZeusTransformUtils.preCheckCast(r1.getFirst(), String.class, "com.obric.memorydata.plugin");
        List<FileEntity> r2 = (List) ZeusTransformUtils.preCheckCast(r1.getSecond(), List.class, "com.obric.memorydata.plugin");
        MessageStatusTypeEnum r0 = a(Integer.valueOf(r3.getInt(((C0654b) ZeusTransformUtils.preCheckCast(r22, C0654b.class, "com.obric.memorydata.plugin")).d())));
        MessageEntity r4 = new MessageEntity(com.obric.memorydata.personalcontext.external.message.a.b(r5), r14, r14, r16, r17, null);
        r4.setMessageStatusType(r0);
        r4.setFiles(r2);
        return r4;
    L10:
        if (r7 == 128) goto L12;
        return null;
    }

    public static final /* synthetic */ MessageEntity b(b r2, ContentResolver r3, Cursor r4, a r5) {
        return r2.b(r3, (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
    }

    private static final C0654b b(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "cursor");
        return new C0654b(r3);
    }

    private static final Unit b(List r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin")).get(com.obric.memorydata.personalcontext.external.message.a.j()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.b(r2);
    L9:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L8:
        r3 = null;
        goto L9
    L11:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final MessageEntity c(ContentResolver r13, Cursor r14, a r15) {
        Cursor r16 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r14, Cursor.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, c.class) == true) goto L5;
        return null;
    L5:
        if (((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).a() == (-1)) goto L25;
        String r0 = String.valueOf(r16.getLong(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).a()));
        long r7 = r16.getLong(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).b());
        String r2 = r16.getString(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).c());
        if (r2 != null) goto L11;
        r2 = "";
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L16;
        List<String> r17 = a(Long.valueOf(r16.getLong(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).e())), r13);
    L17:
        List<String> r9 = r17;
        String r18 = r16.getString(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).f());
        if (r18 != null) goto L20;
        String r10 = "";
    L21:
        MessageStatusTypeEnum r12 = a(Integer.valueOf(r16.getInt(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).d())));
        MessageStatusTypeEnum r19 = MessageStatusTypeEnum.DRAFT;
        MessageEntity r110 = new MessageEntity(com.obric.memorydata.personalcontext.external.message.a.c(r0), r7, r7, r9, r10, null);
        r110.setMessageStatusType(r12);
        r110.setFiles(((c) ZeusTransformUtils.preCheckCast(r15, c.class, "com.obric.memorydata.plugin")).g());
        return r110;
    L20:
        r10 = r18;
        goto L21
    L16:
        String r111 = g.f12138a.c(r2);
        ArrayList r3 = new ArrayList();
        r3.add(r111);
        r17 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        goto L17
    L13:
        r4 = false;
        goto L14
    L25:
        return null;
    }

    public static final /* synthetic */ MessageEntity c(b r2, ContentResolver r3, Cursor r4, a r5) {
        return r2.c(r3, (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin"), r5);
    }

    private static final Unit c(List r6, List r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "rows");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L18;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r10.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(com.obric.memorydata.personalcontext.external.message.a.i()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.a(r2);
        if (r3 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("date"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r1);
        if (r4 == null) goto L15;
        long r5 = r4.longValue();
    L16:
        r8.add(new EntityIdData(r3, 101, r5));
    L15:
        r5 = 0;
        goto L16
    L18:
        return Unit.INSTANCE;
    }

    private static final Unit d(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rows");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L18;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(com.obric.memorydata.personalcontext.external.message.a.j()), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r3 = com.obric.memorydata.personalcontext.external.message.a.b(r2);
        if (r3 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("date"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L15;
        Long r4 = StringsKt.toLongOrNull(r1);
        if (r4 == null) goto L15;
        long r5 = r4.longValue() * 1000;
    L16:
        r9.add(new EntityIdData(r3, 101, r5));
    L15:
        r5 = 0;
        goto L16
    L18:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$18f4cO1nlfvjASD-9YNOQZKEuzo, reason: not valid java name */
    public static /* synthetic */ Unit m1072lambda$18f4cO1nlfvjASD9YNOQZKEuzo(List r0, List r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ c lambda$2X2Xz_ScizHXh9Kdb0RWtAnrqtg(e r0, Cursor r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$5Gx9re69pqm0C4XZRRCnS0RZj0I(List r0, List r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8oTHDo11oZl5dnp6Ibx-3fHUjJ8, reason: not valid java name */
    public static /* synthetic */ d m1073lambda$8oTHDo11oZl5dnp6Ibx3fHUjJ8(Cursor r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$KcGr1UJlsKnQ6alMsXfUyDtf8c0(List r0, List r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ C0654b lambda$_K4_GrKS2oAA860J5mue12xiUeI(Cursor r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$bER1raVbelHul-VSXh-FUIBKMg4, reason: not valid java name */
    public static /* synthetic */ Unit m1074lambda$bER1raVbelHulVSXhFUIBKMg4(e r0, List r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$kE0wKWqMe5f09EflynlAsHTpLgY(List r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$unizRQCZUvp1LIPKqMhoyVA_oMo(List r0, e r1, List r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12148b;
    }

    public final void a(ContentResolver r11, Uri r12, int r13, String[] r14, String r15, String r16, String[] r17, Function1<? super List<? extends Map<String, String>>, Unit> r18) {
        Function1<? super List<? extends Map<String, String>>, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        Intrinsics.checkNotNullParameter(r12, "uri");
        Intrinsics.checkNotNullParameter(r14, "projection");
        Intrinsics.checkNotNullParameter(r15, "projectionColumnName");
        Intrinsics.checkNotNullParameter(r9, "result");
        g.f12138a.a(r11, r12, r14, r15, r13, r16, r17, r9);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> b(ContentResolver r20, List<String> r21) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r20, "contentResolver");
        Intrinsics.checkNotNullParameter(r2, "entityIds");
        List<AppEntity> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r13 = com.obric.memorydata.personalcontext.external.message.a.f().length();
        int r14 = com.obric.memorydata.personalcontext.external.message.a.g().length();
        int r15 = com.obric.memorydata.personalcontext.external.message.a.h().length();
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r16.hasNext() == false) goto L54;
        List r0 = (List) ZeusTransformUtils.preCheckCast(r16.next(), List.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Object r6 = r5.next();
        if (com.obric.memorydata.personalcontext.external.message.a.d((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin")) == false) goto L7;
        r4.add(r6);
        goto L7
    L11:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        String r10 = ((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin")).substring(r13);
        Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        r8.add(r10);
        goto L13
    L15:
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L17:
        if (r19.hasNext() == false) goto L21;
        Object r22 = r19.next();
        if (com.obric.memorydata.personalcontext.external.message.a.e((String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin")) == false) goto L17;
        r18.add(r22);
        goto L17
    L21:
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r23, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r25 = r23.iterator();
    L23:
        if (r25.hasNext() == false) goto L25;
        String r26 = ((String) ZeusTransformUtils.preCheckCast(r25.next(), String.class, "com.obric.memorydata.plugin")).substring(r14);
        Intrinsics.checkNotNullExpressionValue(r26, "substring(...)");
        r24.add(r26);
        goto L23
    L25:
        List<String> r27 = (List) ZeusTransformUtils.preCheckCast(r24, List.class, "com.obric.memorydata.plugin");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r28 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r29 = r1.iterator();
    L27:
        if (r29.hasNext() == false) goto L31;
        Object r30 = r29.next();
        if (com.obric.memorydata.personalcontext.external.message.a.f((String) ZeusTransformUtils.preCheckCast(r30, String.class, "com.obric.memorydata.plugin")) == false) goto L27;
        r28.add(r30);
        goto L27
    L31:
        Iterable r31 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r28, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r32 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r33 = r31.iterator();
    L33:
        if (r33.hasNext() == false) goto L35;
        String r34 = ((String) ZeusTransformUtils.preCheckCast(r33.next(), String.class, "com.obric.memorydata.plugin")).substring(r15);
        Intrinsics.checkNotNullExpressionValue(r34, "substring(...)");
        r32.add(r34);
        goto L33
    L35:
        List<String> r35 = (List) ZeusTransformUtils.preCheckCast(r32, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L38;
        $$Lambda$b$8oTHDo11oZl5dnp6Ibx3fHUjJ8 r110 = $$Lambda$b$8oTHDo11oZl5dnp6Ibx3fHUjJ8.INSTANCE;
        b r36 = f12147a;
        Uri r37 = com.obric.memorydata.personalcontext.external.message.a.a();
        Intrinsics.checkNotNullExpressionValue(r37, "<get-SMS_URI>(...)");
        List<String> r111 = r27;
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r36.a(r20, r37, r11, com.obric.memorydata.personalcontext.external.message.a.i(), com.obric.memorydata.personalcontext.external.message.a.k(), r110, (Function3) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsDataRequester$onQueryEntities$1$1(r36), Function3.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
    L40:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L43;
        $$Lambda$b$_K4_GrKS2oAA860J5mue12xiUeI r38 = $$Lambda$b$_K4_GrKS2oAA860J5mue12xiUeI.INSTANCE;
        b r39 = f12147a;
        Uri r40 = com.obric.memorydata.personalcontext.external.message.a.b();
        Intrinsics.checkNotNullExpressionValue(r40, "<get-MMS_URI>(...)");
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r39.a(r20, r40, r111, com.obric.memorydata.personalcontext.external.message.a.j(), com.obric.memorydata.personalcontext.external.message.a.l(), r38, (Function3) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsDataRequester$onQueryEntities$1$2(r39), Function3.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
    L43:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L53;
        final e r41 = f.f12159a.a();     // Catch: Exception -> L51
        if (r41 == null) goto L47;
        Uri r42 = r41.a();     // Catch: Exception -> L51
    L48:
        if (r42 == null) goto L53;
        Function1<? super Cursor, ? extends a> r43 = new $$Lambda$b$2X2Xz_ScizHXh9Kdb0RWtAnrqtg(r41);     // Catch: Exception -> L51
        b r44 = f12147a;     // Catch: Exception -> L51
        Uri r45 = r41.a();     // Catch: Exception -> L51
        Intrinsics.checkNotNull(r45);     // Catch: Exception -> L51
        r12.addAll((Collection) ZeusTransformUtils.preCheckCast(r44.a(r20, r45, r35, r41.b(), r41.i(), r43, (Function3) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsDataRequester$onQueryEntities$1$3(r44), Function3.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L51
        goto L53
    L47:
        r42 = null;
    L51:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsDataRequester", "query rms entities error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L53:
        r13 = r13;
        goto L4
    L38:
        r111 = r27;
        goto L40
    L54:
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalSmsMmsDataRequester", "on query entities:ids=" + r2 + ",entities size=" + r12.size());
        return r12;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r14) {
        Intrinsics.checkNotNullParameter(r14, "contentResolver");
        final List<String> r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g r1 = g.f12138a;
        Uri r3 = com.obric.memorydata.personalcontext.external.message.a.a();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-SMS_URI>(...)");
        r1.a(r14, r3, new String[]{com.obric.memorydata.personalcontext.external.message.a.i()}, com.obric.memorydata.personalcontext.external.message.a.i(), 200, null, null, new $$Lambda$b$kE0wKWqMe5f09EflynlAsHTpLgY(r11));
        g r2 = g.f12138a;
        Uri r4 = com.obric.memorydata.personalcontext.external.message.a.b();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-MMS_URI>(...)");
        r2.a(r14, r4, new String[]{com.obric.memorydata.personalcontext.external.message.a.j()}, com.obric.memorydata.personalcontext.external.message.a.j(), 200, null, null, new $$Lambda$b$KcGr1UJlsKnQ6alMsXfUyDtf8c0(r11));
        final e r5 = f.f12159a.a();     // Catch: Exception -> L10
        if (r5 == null) goto L6;
        Uri r6 = r5.a();     // Catch: Exception -> L10
    L7:
        if (r6 == null) goto L13;
        g r7 = g.f12138a;     // Catch: Exception -> L10
        Uri r8 = r5.a();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L10
        r7.a(r14, r8, new String[]{r5.b()}, r5.b(), 200, null, null, new $$Lambda$b$unizRQCZUvp1LIPKqMhoyVA_oMo(r11, r5));     // Catch: Exception -> L10
    L13:
        return a(r14, r11);
    L6:
        r6 = null;
    L10:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsDataRequester", "query rms error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<EntityIdData> d(ContentResolver r17) {
        Intrinsics.checkNotNullParameter(r17, "contentResolver");
        final List<EntityIdData> r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g r1 = g.f12138a;
        Uri r3 = com.obric.memorydata.personalcontext.external.message.a.a();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-SMS_URI>(...)");
        r1.a(r17, r3, new String[]{com.obric.memorydata.personalcontext.external.message.a.i(), "date"}, com.obric.memorydata.personalcontext.external.message.a.i(), 2000, null, null, new $$Lambda$b$5Gx9re69pqm0C4XZRRCnS0RZj0I(r12));
        g r2 = g.f12138a;
        Uri r4 = com.obric.memorydata.personalcontext.external.message.a.b();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-MMS_URI>(...)");
        r2.a(r17, r4, new String[]{com.obric.memorydata.personalcontext.external.message.a.j(), "date", "m_type"}, com.obric.memorydata.personalcontext.external.message.a.j(), 2000, "m_type IN (?, ?)", new String[]{BDLocationException.ERROR_CODE_EXCEPTION, BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD}, new $$Lambda$b$18f4cO1nlfvjASD9YNOQZKEuzo(r12));
        final e r5 = f.f12159a.a();     // Catch: Exception -> L10
        if (r5 == null) goto L6;
        Uri r6 = r5.a();     // Catch: Exception -> L10
    L7:
        if (r6 == null) goto L12;
        g r7 = g.f12138a;     // Catch: Exception -> L10
        Uri r8 = r5.a();     // Catch: Exception -> L10
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L10
        r7.a(r17, r8, new String[]{r5.b(), r5.c()}, r5.b(), 2000, null, null, new $$Lambda$b$bER1raVbelHulVSXhFUIBKMg4(r5, r12));     // Catch: Exception -> L10
    L12:
        return r12;
    L6:
        r6 = null;
    L10:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsDataRequester", "query rms id data error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L12
    }
}
