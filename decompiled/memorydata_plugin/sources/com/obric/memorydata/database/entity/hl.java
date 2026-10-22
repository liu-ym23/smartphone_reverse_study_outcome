package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b:\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B«\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010!\u001a\u00020\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\b\u0010^\u001a\u00020_H\u0014J&\u0010`\u001a\u00020_2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050b2\u0006\u0010c\u001a\u00020\u00012\u0006\u0010d\u001a\u00020\u0001H\u0014J\b\u0010e\u001a\u00020fH\u0014J\u0018\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u0005H\u0016J\u0012\u0010k\u001a\u0004\u0018\u00010h2\u0006\u0010i\u001a\u00020\u0005H\u0016J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u0005HÆ\u0003J\t\u0010s\u001a\u00020\tHÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010u\u001a\u00020\u0005HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0013HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010AJ\t\u0010|\u001a\u00020\u0013HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\"HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010$HÆ\u0003JÔ\u0002\u0010\u0089\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$HÆ\u0001¢\u0006\u0003\u0010\u008a\u0001J\u0016\u0010\u008b\u0001\u001a\u00020\u00132\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001HÖ\u0003J\n\u0010\u008e\u0001\u001a\u00020\tHÖ\u0001J\n\u0010\u008f\u0001\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u00108R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010,R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010,R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010B\u001a\u0004\b@\u0010AR\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010>R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bC\u0010,R \u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010,\"\u0004\bE\u00108R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010,\"\u0004\bG\u00108R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u00108R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010,\"\u0004\bK\u00108R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010,\"\u0004\bM\u00108R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010,\"\u0004\bO\u00108R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010,\"\u0004\bQ\u00108R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010,\"\u0004\bS\u00108R\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010,\"\u0004\bU\u00108R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]¨\u0006\u0090\u0001"}, d2 = {"Lcom/obric/memorydata/database/entity/RawScheduleEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, ActivityLifecycle.NAME, MemoryKeyInfoEntity.KEY_ADDRESS, "attendeesIds", "repeatDescription", "allDay", "", "note", "completed", "isFavorite", "reminderDesc", "fullContent", "url", "attendeesText", "organizer", "priority", "categories", "icsId", "recurrenceId", "rawRrule", "contentTimeEntity", "Lcom/obric/memorydata/database/entity/ScheduleContentTime;", "calendarType", "Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/database/entity/ScheduleContentTime;Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "setCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getName", "getAddress", "getAttendeesIds", "getRepeatDescription", "getAllDay", "()Z", "getNote", "getCompleted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getReminderDesc", "getFullContent", "setFullContent", "getUrl", "setUrl", "getAttendeesText", "setAttendeesText", "getOrganizer", "setOrganizer", "getPriority", "setPriority", "getCategories", "setCategories", "getIcsId", "setIcsId", "getRecurrenceId", "setRecurrenceId", "getRawRrule", "setRawRrule", "getContentTimeEntity", "()Lcom/obric/memorydata/database/entity/ScheduleContentTime;", "setContentTimeEntity", "(Lcom/obric/memorydata/database/entity/ScheduleContentTime;)V", "getCalendarType", "()Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;", "setCalendarType", "(Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)V", "onFirstIndex", "", "onUpdate", "updateColumns", "", "oldEntity", "newEntity", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "copy", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/database/entity/ScheduleContentTime;Lcom/obric/capabilitykit/entity/enums/CalendarTypeEnum;)Lcom/obric/memorydata/database/entity/RawScheduleEntity;", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hl extends d {
    private String A;
    private hz B;
    private CalendarTypeEnum C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9186b;
    private long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final boolean n;
    private final String o;
    private final Boolean p;
    private final boolean q;
    private final String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public hl(long r23, String r25, long r26, long r28, int r30, long r31, String r33, int r34, String r35, String r36, String r37, String r38, String r39, boolean r40, String r41, Boolean r42, boolean r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, hz r54, CalendarTypeEnum r55) {
        Intrinsics.checkNotNullParameter(r25, "entityId");
        Intrinsics.checkNotNullParameter(r33, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r36, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r54, "contentTimeEntity");
        super(r23, r25, r26, r28, r30, r31, r33, r34, r35, null, null, null, 3584, null);
        this.f9185a = r23;
        this.f9186b = r25;
        this.c = r26;
        this.d = r28;
        this.e = r30;
        this.f = r31;
        this.g = r33;
        this.h = r34;
        this.i = r35;
        this.j = r36;
        this.k = r37;
        this.l = r38;
        this.m = r39;
        this.n = r40;
        this.o = r41;
        this.p = r42;
        this.q = r43;
        this.r = r44;
        this.s = r45;
        this.t = r46;
        this.u = r47;
        this.v = r48;
        this.w = r49;
        this.x = r50;
        this.y = r51;
        this.z = r52;
        this.A = r53;
        this.B = r54;
        this.C = r55;
    }

    public /* synthetic */ hl(long r38, String r40, long r41, long r43, int r45, long r46, String r48, int r49, String r50, String r51, String r52, String r53, String r54, boolean r55, String r56, Boolean r57, boolean r58, String r59, String r60, String r61, String r62, String r63, String r64, String r65, String r66, String r67, String r68, hz r69, CalendarTypeEnum r70, int r71, DefaultConstructorMarker r72) {
        if ((r71 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r71 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r71 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L15:
        if ((262144 & r71) == 0) goto L17;
        String r26 = null;
    L19:
        if ((524288 & r71) == 0) goto L21;
        String r27 = null;
    L23:
        if ((1048576 & r71) == 0) goto L25;
        String r28 = null;
    L27:
        if ((2097152 & r71) == 0) goto L29;
        String r29 = null;
    L31:
        if ((4194304 & r71) == 0) goto L33;
        String r30 = null;
    L35:
        if ((8388608 & r71) == 0) goto L37;
        String r31 = null;
    L39:
        if ((16777216 & r71) == 0) goto L41;
        String r32 = null;
    L43:
        if ((33554432 & r71) == 0) goto L45;
        String r33 = null;
    L47:
        if ((67108864 & r71) == 0) goto L49;
        String r34 = null;
    L51:
        if ((r71 & SQLiteDatabase.CREATE_IF_NECESSARY) == 0) goto L53;
        CalendarTypeEnum r36 = null;
    L54:
        this(r4, r40, r41, r43, r45, r12, r48, r49, r16, r51, r52, r53, r54, r55, r56, r57, r58, r59, r26, r27, r28, r29, r30, r31, r32, r33, r34, r69, r36);
        return;
    L53:
        r36 = r70;
        goto L54
    L49:
        r34 = r68;
        goto L51
    L45:
        r33 = r67;
        goto L47
    L41:
        r32 = r66;
        goto L43
    L37:
        r31 = r65;
        goto L39
    L33:
        r30 = r64;
        goto L35
    L29:
        r29 = r63;
        goto L31
    L25:
        r28 = r62;
        goto L27
    L21:
        r27 = r61;
        goto L23
    L17:
        r26 = r60;
        goto L19
    L13:
        r16 = r50;
        goto L15
    L9:
        r12 = r46;
        goto L11
    L5:
        r4 = r38;
        goto L7
    }

    public final String a() {
        return this.j;
    }

    public void a(long r1) {
        this.c = r1;
    }

    public final String b() {
        return this.k;
    }

    public final String c() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        String r1 = this.l;
        if (r1 != null) goto L21;
    L11:
        List<String> r2 = null;
    L12:
        if (r2 == null) goto L18;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByEntityIdList(r2), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r0.iterator();
    L15:
        if (r4.hasNext() == false) goto L17;
        AppEntity r5 = ((fx) ZeusTransformUtils.preCheckCast(r4.next(), fx.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ContactEntity");
        r3.add((ContactEntity) ZeusTransformUtils.preCheckCast(r5, ContactEntity.class, "com.obric.memorydata.plugin"));
        goto L15
    L17:
        List<ContactEntity> r6 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    L19:
        ScheduleEntity r7 = new ScheduleEntity(getEntityId(), getCreateTime(), getModifyTime(), this.j, "", "");
        r7.setUuid(getUuid());
        r7.setAddress(this.k);
        r7.setAttendees(r6);
        r7.setRepeatDescription(this.m);
        r7.setAllDay(this.n);
        r7.setNote(this.o);
        r7.setCompleted(this.p);
        r7.setFavorite(this.q);
        r7.setReminderDesc(this.r);
        r7.setStartTimestamp(Long.valueOf(this.B.a()));
        r7.setEndTimestamp(Long.valueOf(this.B.d()));
        r7.setCalendarType(this.C);
        r7.setIcsId(this.y);
        r7.setRecurrenceId(this.z);
        r7.setRawRrule(this.A);
        r7.setICalendarText(null);
        r7.set_packageName(getPackageName());
        return (AppEntity) ZeusTransformUtils.preCheckCast(r7, AppEntity.class, "com.obric.memorydata.plugin");
    L18:
        r6 = null;
        goto L19
    L21:
        r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r1, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L8:
        e = e;
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder();
    L10:
        IRunLog.a.b(r8, "GsonExt", r9.append("toListObj error : ").append(e).toString(), null, 4, null);
    L6:
        e = e;
        r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new ia(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.m;
    }

    public final boolean e() {
        return this.n;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hl.class) == true) goto L8;
        return false;
    L8:
        hl r10 = (hl) ZeusTransformUtils.preCheckCast(r9, hl.class, "com.obric.memorydata.plugin");
        if (this.f9185a == r10.f9185a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9186b, r10.f9186b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r10.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r10.z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r10.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r10.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r10.C) goto L95;
        return false;
    L95:
        return true;
    }

    public final String f() {
        return this.o;
    }

    public final Boolean g() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9186b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9185a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    public final boolean h() {
        return this.q;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9185a) * 31) + this.f9186b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.j.hashCode()) * 31;
        String r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.l;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.m;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.n)) * 31;
        String r14 = this.o;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Boolean r17 = this.p;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + Boolean.hashCode(this.q)) * 31;
        String r20 = this.r;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.s;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.t;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        String r29 = this.u;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r28 + r30) * 31;
        String r32 = this.v;
        if (r32 != null) goto L45;
        int r33 = 0;
    L46:
        int r34 = (r31 + r33) * 31;
        String r35 = this.w;
        if (r35 != null) goto L49;
        int r36 = 0;
    L50:
        int r37 = (r34 + r36) * 31;
        String r38 = this.x;
        if (r38 != null) goto L53;
        int r39 = 0;
    L54:
        int r40 = (r37 + r39) * 31;
        String r41 = this.y;
        if (r41 != null) goto L57;
        int r42 = 0;
    L58:
        int r43 = (r40 + r42) * 31;
        String r44 = this.z;
        if (r44 != null) goto L61;
        int r45 = 0;
    L62:
        int r46 = (r43 + r45) * 31;
        String r47 = this.A;
        if (r47 != null) goto L65;
        int r48 = 0;
    L66:
        int r49 = (((r46 + r48) * 31) + this.B.hashCode()) * 31;
        CalendarTypeEnum r50 = this.C;
        if (r50 == null) goto L71;
        r2 = r50.hashCode();
    L71:
        return r49 + r2;
    L65:
        r48 = r47.hashCode();
        goto L66
    L61:
        r45 = r44.hashCode();
        goto L62
    L57:
        r42 = r41.hashCode();
        goto L58
    L53:
        r39 = r38.hashCode();
        goto L54
    L49:
        r36 = r35.hashCode();
        goto L50
    L45:
        r33 = r32.hashCode();
        goto L46
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.r;
    }

    public final String j() {
        return this.s;
    }

    public final String k() {
        return this.t;
    }

    public final String l() {
        return this.u;
    }

    public final String m() {
        return this.v;
    }

    public final String n() {
        return this.w;
    }

    public final String o() {
        return this.x;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onFirstIndex() {
        super.onFirstIndex();
        a(RangesKt.coerceAtMost(System.currentTimeMillis(), getModifyTime()));
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r3, d r4, d r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "updateColumns");
        Intrinsics.checkNotNullParameter(r4, "oldEntity");
        Intrinsics.checkNotNullParameter(r5, "newEntity");
        super.onUpdate(r6, r4, r5);
        a(r4.getCreateTime());
    }

    public final String p() {
        return this.y;
    }

    public final String q() {
        return this.z;
    }

    public final String r() {
        return this.A;
    }

    public final hz s() {
        return this.B;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9185a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }

    public final CalendarTypeEnum t() {
        return this.C;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawScheduleEntity(id=").append(this.f9185a).append(", entityId=").append(this.f9186b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", name=").append(this.j).append(", address=").append(this.k).append(", attendeesIds=");
        r0.append(this.l).append(", repeatDescription=").append(this.m).append(", allDay=").append(this.n).append(", note=").append(this.o).append(", completed=").append(this.p).append(", isFavorite=").append(this.q).append(", reminderDesc=").append(this.r).append(", fullContent=").append(this.s).append(", url=").append(this.t).append(", attendeesText=").append(this.u).append(", organizer=").append(this.v).append(", priority=").append(this.w);
        r0.append(", categories=").append(this.x).append(", icsId=").append(this.y).append(", recurrenceId=").append(this.z).append(", rawRrule=").append(this.A).append(", contentTimeEntity=").append(this.B).append(", calendarType=").append(this.C).append(')');
        return r0.toString();
    }
}
