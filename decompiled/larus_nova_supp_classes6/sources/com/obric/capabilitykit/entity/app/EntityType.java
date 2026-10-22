package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity;
import com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventScheduleMemoryEntity;
import com.obric.capabilitykit.entity.memory.EventTodoMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoAnniversaryMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoDocumentsMemoryEntity;
import com.obric.capabilitykit.entity.memory.InfoRelationshipMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderHotelMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity;
import com.obric.capabilitykit.entity.memory.OrderTrainMemoryEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R%\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002050403¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityType;", "", "()V", "ALARM", "", "ALBUM", "APP_INFO", "AUDITORY_RECORDING", "BROWSER_BOOKMARK", "CALENDAR_EVENT", "CALL_HISTORY", "CLOUD_DOCUMENT", "CONTACT", "COUNTDOWN", "DOUBAO_ACCOUNT", "EVENT_TASK", "FILE", "GROUP_CHAT", "ICALENDAR_PROTOCOL", "IM_CONTACT", "INVALIDATE_ENTITY_TYPE", "LIFE_LOG", "MEMORY_COLLECT_CONTENT", "MEMORY_COLLECT_STORE", "MEMORY_COMMON_TEXT", "MEMORY_EVENT_SCHEDULE", "MEMORY_EVENT_TODO", "MEMORY_INFO_ADDRESS", "MEMORY_INFO_ANNIVERSARY", "MEMORY_INFO_COMMON", "MEMORY_INFO_DOCUMENTS", "MEMORY_INFO_RELATIONSHIP", "MEMORY_ORDER_COMMON", "MEMORY_ORDER_FLIGHT", "MEMORY_ORDER_HOTEL", "MEMORY_ORDER_MOVIE_TICKET", "MEMORY_ORDER_TICKET", "MEMORY_ORDER_TRAIN", "MESSAGE", "MUSIC", "NOTE", "PHOTO", "PHOTO_FACE", "PROACTIVE_MEMORY", "RECORDING", "SCHEDULE", "SIM_CARD", "STOCK", "USER_PROFILE", "WEBSITE", "classMap", "", "Lcom/obric/capabilitykit/entity/app/EntityClassData;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getClassMap", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EntityType {
    public static final int ALARM = 701;
    public static final int ALBUM = 302;
    public static final int APP_INFO = 1701;
    public static final int AUDITORY_RECORDING = 502;
    public static final int BROWSER_BOOKMARK = 902;
    public static final int CALENDAR_EVENT = 403;
    public static final int CALL_HISTORY = 202;
    public static final int CLOUD_DOCUMENT = 1001;
    public static final int CONTACT = 201;
    public static final int COUNTDOWN = 702;
    public static final int DOUBAO_ACCOUNT = 1301;
    public static final int EVENT_TASK = 1601;
    public static final int FILE = 801;
    public static final int GROUP_CHAT = 203;
    public static final int ICALENDAR_PROTOCOL = 402;
    public static final int IM_CONTACT = 1201;
    public static final EntityType INSTANCE = null;
    public static final int INVALIDATE_ENTITY_TYPE = -1;
    public static final int LIFE_LOG = 1401;
    public static final int MEMORY_COLLECT_CONTENT = 10201;
    public static final int MEMORY_COLLECT_STORE = 10202;
    public static final int MEMORY_COMMON_TEXT = 10401;
    public static final int MEMORY_EVENT_SCHEDULE = 10301;
    public static final int MEMORY_EVENT_TODO = 10302;
    public static final int MEMORY_INFO_ADDRESS = 10102;
    public static final int MEMORY_INFO_ANNIVERSARY = 10103;
    public static final int MEMORY_INFO_COMMON = 10105;
    public static final int MEMORY_INFO_DOCUMENTS = 10101;
    public static final int MEMORY_INFO_RELATIONSHIP = 10104;
    public static final int MEMORY_ORDER_COMMON = 10005;
    public static final int MEMORY_ORDER_FLIGHT = 10001;
    public static final int MEMORY_ORDER_HOTEL = 10004;
    public static final int MEMORY_ORDER_MOVIE_TICKET = 10003;
    public static final int MEMORY_ORDER_TICKET = 10006;
    public static final int MEMORY_ORDER_TRAIN = 10002;
    public static final int MESSAGE = 101;
    public static final int MUSIC = 1801;
    public static final int NOTE = 601;
    public static final int PHOTO = 301;
    public static final int PHOTO_FACE = 303;
    public static final int PROACTIVE_MEMORY = 20001;
    public static final int RECORDING = 501;
    public static final int SCHEDULE = 401;
    public static final int SIM_CARD = 204;
    public static final int STOCK = 1101;
    public static final int USER_PROFILE = 1501;
    public static final int WEBSITE = 901;
    private static final Map<Integer, EntityClassData<? extends AppEntity>> classMap = null;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function1<Parcel, AlarmEntity> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(1);
        }

        public final AlarmEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AlarmEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a0 extends Lambda implements Function1<Parcel, EventTodoMemoryEntity> {
        public static final a0 a = null;

        static {
            a = new a0();
        }

        public a0() {
            super(1);
        }

        public final EventTodoMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new EventTodoMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class b extends Lambda implements Function1<Parcel, CountdownEntity> {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
            super(1);
        }

        public final CountdownEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CountdownEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class b0 extends Lambda implements Function1<Parcel, CommonTextMemoryEntity> {
        public static final b0 a = null;

        static {
            a = new b0();
        }

        public b0() {
            super(1);
        }

        public final CommonTextMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CommonTextMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/FileEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class c extends Lambda implements Function1<Parcel, FileEntity> {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
            super(1);
        }

        public final FileEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new FileEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class c0 extends Lambda implements Function1<Parcel, ProactiveMemoryEntity> {
        public static final c0 a = null;

        static {
            a = new c0();
        }

        public c0() {
            super(1);
        }

        public final ProactiveMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ProactiveMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/WebsiteEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/WebsiteEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class d extends Lambda implements Function1<Parcel, WebsiteEntity> {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
            super(1);
        }

        public final WebsiteEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new WebsiteEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class d0 extends Lambda implements Function1<Parcel, ICSProtocolEntity> {
        public static final d0 a = null;

        static {
            a = new d0();
        }

        public d0() {
            super(1);
        }

        public final ICSProtocolEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ICSProtocolEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/BrowserBookmarkEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/BrowserBookmarkEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class e extends Lambda implements Function1<Parcel, BrowserBookmarkEntity> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(1);
        }

        public final BrowserBookmarkEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new BrowserBookmarkEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/DoubaoAccountEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/DoubaoAccountEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class e0 extends Lambda implements Function1<Parcel, DoubaoAccountEntity> {
        public static final e0 a = null;

        static {
            a = new e0();
        }

        public e0() {
            super(1);
        }

        public final DoubaoAccountEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new DoubaoAccountEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class f extends Lambda implements Function1<Parcel, GroupChatEntity> {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
            super(1);
        }

        public final GroupChatEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new GroupChatEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/LifeLogEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/LifeLogEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class f0 extends Lambda implements Function1<Parcel, LifeLogEntity> {
        public static final f0 a = null;

        static {
            a = new f0();
        }

        public f0() {
            super(1);
        }

        public final LifeLogEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new LifeLogEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class g extends Lambda implements Function1<Parcel, CloudDocumentEntity> {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
            super(1);
        }

        public final CloudDocumentEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CloudDocumentEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class g0 extends Lambda implements Function1<Parcel, CallHistoryEntity> {
        public static final g0 a = null;

        static {
            a = new g0();
        }

        public g0() {
            super(1);
        }

        public final CallHistoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CallHistoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/StockEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class h extends Lambda implements Function1<Parcel, StockEntity> {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
            super(1);
        }

        public final StockEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new StockEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class h0 extends Lambda implements Function1<Parcel, UserProfileEntity> {
        public static final h0 a = null;

        static {
            a = new h0();
        }

        public h0() {
            super(1);
        }

        public final UserProfileEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new UserProfileEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class i extends Lambda implements Function1<Parcel, PhotoFaceEntity> {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
            super(1);
        }

        public final PhotoFaceEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new PhotoFaceEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class i0 extends Lambda implements Function1<Parcel, EventTaskEntity> {
        public static final i0 a = null;

        static {
            a = new i0();
        }

        public i0() {
            super(1);
        }

        public final EventTaskEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new EventTaskEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class j extends Lambda implements Function1<Parcel, AuditoryRecordingEntity> {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
            super(1);
        }

        public final AuditoryRecordingEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AuditoryRecordingEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class j0 extends Lambda implements Function1<Parcel, AppInfoEntity> {
        public static final j0 a = null;

        static {
            a = new j0();
        }

        public j0() {
            super(1);
        }

        public final AppInfoEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AppInfoEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/MessageEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class k extends Lambda implements Function1<Parcel, MessageEntity> {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
            super(1);
        }

        public final MessageEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new MessageEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/MusicEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class k0 extends Lambda implements Function1<Parcel, MusicEntity> {
        public static final k0 a = null;

        static {
            a = new k0();
        }

        public k0() {
            super(1);
        }

        public final MusicEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new MusicEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class l extends Lambda implements Function1<Parcel, OrderFlightMemoryEntity> {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
            super(1);
        }

        public final OrderFlightMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderFlightMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class l0 extends Lambda implements Function1<Parcel, SimCardEntity> {
        public static final l0 a = null;

        static {
            a = new l0();
        }

        public l0() {
            super(1);
        }

        public final SimCardEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SimCardEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class m extends Lambda implements Function1<Parcel, OrderTrainMemoryEntity> {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
            super(1);
        }

        public final OrderTrainMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderTrainMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class m0 extends Lambda implements Function1<Parcel, PhotoEntity> {
        public static final m0 a = null;

        static {
            a = new m0();
        }

        public m0() {
            super(1);
        }

        public final PhotoEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new PhotoEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class n extends Lambda implements Function1<Parcel, OrderMovieTicketMemoryEntity> {
        public static final n a = null;

        static {
            a = new n();
        }

        public n() {
            super(1);
        }

        public final OrderMovieTicketMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderMovieTicketMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class n0 extends Lambda implements Function1<Parcel, AlbumEntity> {
        public static final n0 a = null;

        static {
            a = new n0();
        }

        public n0() {
            super(1);
        }

        public final AlbumEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new AlbumEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class o extends Lambda implements Function1<Parcel, OrderTicketMemoryEntity> {
        public static final o a = null;

        static {
            a = new o();
        }

        public o() {
            super(1);
        }

        public final OrderTicketMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderTicketMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class o0 extends Lambda implements Function1<Parcel, ScheduleEntity> {
        public static final o0 a = null;

        static {
            a = new o0();
        }

        public o0() {
            super(1);
        }

        public final ScheduleEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ScheduleEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class p extends Lambda implements Function1<Parcel, OrderHotelMemoryEntity> {
        public static final p a = null;

        static {
            a = new p();
        }

        public p() {
            super(1);
        }

        public final OrderHotelMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderHotelMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class p0 extends Lambda implements Function1<Parcel, RecordingEntity> {
        public static final p0 a = null;

        static {
            a = new p0();
        }

        public p0() {
            super(1);
        }

        public final RecordingEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new RecordingEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class q extends Lambda implements Function1<Parcel, OrderCommonMemoryEntity> {
        public static final q a = null;

        static {
            a = new q();
        }

        public q() {
            super(1);
        }

        public final OrderCommonMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new OrderCommonMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/NoteEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class q0 extends Lambda implements Function1<Parcel, NoteEntity> {
        public static final q0 a = null;

        static {
            a = new q0();
        }

        public q0() {
            super(1);
        }

        public final NoteEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new NoteEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class r extends Lambda implements Function1<Parcel, InfoDocumentsMemoryEntity> {
        public static final r a = null;

        static {
            a = new r();
        }

        public r() {
            super(1);
        }

        public final InfoDocumentsMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InfoDocumentsMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/InfoAddressMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/InfoAddressMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class s extends Lambda implements Function1<Parcel, InfoAddressMemoryEntity> {
        public static final s a = null;

        static {
            a = new s();
        }

        public s() {
            super(1);
        }

        public final InfoAddressMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InfoAddressMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class t extends Lambda implements Function1<Parcel, InfoAnniversaryMemoryEntity> {
        public static final t a = null;

        static {
            a = new t();
        }

        public t() {
            super(1);
        }

        public final InfoAnniversaryMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InfoAnniversaryMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/InfoRelationshipMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/InfoRelationshipMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class u extends Lambda implements Function1<Parcel, InfoRelationshipMemoryEntity> {
        public static final u a = null;

        static {
            a = new u();
        }

        public u() {
            super(1);
        }

        public final InfoRelationshipMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InfoRelationshipMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/app/ContactEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class v extends Lambda implements Function1<Parcel, ContactEntity> {
        public static final v a = null;

        static {
            a = new v();
        }

        public v() {
            super(1);
        }

        public final ContactEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ContactEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class w extends Lambda implements Function1<Parcel, InfoCommonMemoryEntity> {
        public static final w a = null;

        static {
            a = new w();
        }

        public w() {
            super(1);
        }

        public final InfoCommonMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new InfoCommonMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class x extends Lambda implements Function1<Parcel, CollectContentMemoryEntity> {
        public static final x a = null;

        static {
            a = new x();
        }

        public x() {
            super(1);
        }

        public final CollectContentMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CollectContentMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class y extends Lambda implements Function1<Parcel, CollectStoreMemoryEntity> {
        public static final y a = null;

        static {
            a = new y();
        }

        public y() {
            super(1);
        }

        public final CollectStoreMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new CollectStoreMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/os/Parcel;", "parcel", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "invoke", "(Landroid/os/Parcel;)Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class z extends Lambda implements Function1<Parcel, EventScheduleMemoryEntity> {
        public static final z a = null;

        static {
            a = new z();
        }

        public z() {
            super(1);
        }

        public final EventScheduleMemoryEntity a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new EventScheduleMemoryEntity(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Parcel) r1);
        }
    }

    static {
        INSTANCE = new EntityType();
        classMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(MESSAGE), new EntityClassData(MessageEntity.class, MessageEntity.CREATOR.getVersion(), k.a)), TuplesKt.to(Integer.valueOf(CONTACT), new EntityClassData(ContactEntity.class, ContactEntity.CREATOR.getVersion(), v.a)), TuplesKt.to(Integer.valueOf(CALL_HISTORY), new EntityClassData(CallHistoryEntity.class, CallHistoryEntity.CREATOR.getVersion(), g0.a)), TuplesKt.to(Integer.valueOf(SIM_CARD), new EntityClassData(SimCardEntity.class, SimCardEntity.CREATOR.getVersion(), l0.a)), TuplesKt.to(Integer.valueOf(PHOTO), new EntityClassData(PhotoEntity.class, PhotoEntity.CREATOR.getVersion(), m0.a)), TuplesKt.to(Integer.valueOf(ALBUM), new EntityClassData(AlbumEntity.class, AlbumEntity.CREATOR.getVersion(), n0.a)), TuplesKt.to(Integer.valueOf(SCHEDULE), new EntityClassData(ScheduleEntity.class, ScheduleEntity.CREATOR.getVersion(), o0.a)), TuplesKt.to(Integer.valueOf(RECORDING), new EntityClassData(RecordingEntity.class, RecordingEntity.CREATOR.getVersion(), p0.a)), TuplesKt.to(Integer.valueOf(NOTE), new EntityClassData(NoteEntity.class, NoteEntity.CREATOR.getVersion(), q0.a)), TuplesKt.to(Integer.valueOf(ALARM), new EntityClassData(AlarmEntity.class, AlarmEntity.CREATOR.getVersion(), a.a)), TuplesKt.to(Integer.valueOf(COUNTDOWN), new EntityClassData(CountdownEntity.class, CountdownEntity.CREATOR.getVersion(), b.a)), TuplesKt.to(Integer.valueOf(FILE), new EntityClassData(FileEntity.class, FileEntity.CREATOR.getVersion(), c.a)), TuplesKt.to(Integer.valueOf(WEBSITE), new EntityClassData(WebsiteEntity.class, WebsiteEntity.CREATOR.getVersion(), d.a)), TuplesKt.to(Integer.valueOf(BROWSER_BOOKMARK), new EntityClassData(BrowserBookmarkEntity.class, BrowserBookmarkEntity.CREATOR.getVersion(), e.a)), TuplesKt.to(Integer.valueOf(GROUP_CHAT), new EntityClassData(GroupChatEntity.class, GroupChatEntity.CREATOR.getVersion(), f.a)), TuplesKt.to(Integer.valueOf(CLOUD_DOCUMENT), new EntityClassData(CloudDocumentEntity.class, CloudDocumentEntity.CREATOR.getVersion(), g.a)), TuplesKt.to(Integer.valueOf(STOCK), new EntityClassData(StockEntity.class, StockEntity.CREATOR.getVersion(), h.a)), TuplesKt.to(Integer.valueOf(PHOTO_FACE), new EntityClassData(PhotoFaceEntity.class, PhotoFaceEntity.CREATOR.getVersion(), i.a)), TuplesKt.to(Integer.valueOf(AUDITORY_RECORDING), new EntityClassData(AuditoryRecordingEntity.class, AuditoryRecordingEntity.CREATOR.getVersion(), j.a)), TuplesKt.to(10001, new EntityClassData(OrderFlightMemoryEntity.class, OrderFlightMemoryEntity.CREATOR.getVersion(), l.a)), TuplesKt.to(10002, new EntityClassData(OrderTrainMemoryEntity.class, OrderTrainMemoryEntity.CREATOR.getVersion(), m.a)), TuplesKt.to(10003, new EntityClassData(OrderMovieTicketMemoryEntity.class, OrderMovieTicketMemoryEntity.CREATOR.getVersion(), n.a)), TuplesKt.to(10006, new EntityClassData(OrderTicketMemoryEntity.class, OrderTicketMemoryEntity.CREATOR.getVersion(), o.a)), TuplesKt.to(10004, new EntityClassData(OrderHotelMemoryEntity.class, OrderHotelMemoryEntity.CREATOR.getVersion(), p.a)), TuplesKt.to(10005, new EntityClassData(OrderCommonMemoryEntity.class, OrderCommonMemoryEntity.CREATOR.getVersion(), q.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_DOCUMENTS), new EntityClassData(InfoDocumentsMemoryEntity.class, InfoDocumentsMemoryEntity.CREATOR.getVersion(), r.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ADDRESS), new EntityClassData(InfoAddressMemoryEntity.class, InfoAddressMemoryEntity.CREATOR.getVersion(), s.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ANNIVERSARY), new EntityClassData(InfoAnniversaryMemoryEntity.class, InfoAnniversaryMemoryEntity.CREATOR.getVersion(), t.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_RELATIONSHIP), new EntityClassData(InfoRelationshipMemoryEntity.class, InfoRelationshipMemoryEntity.CREATOR.getVersion(), u.a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_COMMON), new EntityClassData(InfoCommonMemoryEntity.class, InfoCommonMemoryEntity.CREATOR.getVersion(), w.a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_CONTENT), new EntityClassData(CollectContentMemoryEntity.class, CollectContentMemoryEntity.CREATOR.getVersion(), x.a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_STORE), new EntityClassData(CollectStoreMemoryEntity.class, CollectStoreMemoryEntity.CREATOR.getVersion(), y.a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_SCHEDULE), new EntityClassData(EventScheduleMemoryEntity.class, EventScheduleMemoryEntity.CREATOR.getVersion(), z.a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_TODO), new EntityClassData(EventTodoMemoryEntity.class, EventTodoMemoryEntity.CREATOR.getVersion(), a0.a)), TuplesKt.to(Integer.valueOf(MEMORY_COMMON_TEXT), new EntityClassData(CommonTextMemoryEntity.class, CommonTextMemoryEntity.CREATOR.getVersion(), b0.a)), TuplesKt.to(Integer.valueOf(PROACTIVE_MEMORY), new EntityClassData(ProactiveMemoryEntity.class, ProactiveMemoryEntity.CREATOR.getVersion(), c0.a)), TuplesKt.to(Integer.valueOf(ICALENDAR_PROTOCOL), new EntityClassData(ICSProtocolEntity.class, ICSProtocolEntity.CREATOR.getVersion(), d0.a)), TuplesKt.to(Integer.valueOf(DOUBAO_ACCOUNT), new EntityClassData(DoubaoAccountEntity.class, DoubaoAccountEntity.CREATOR.getVersion(), e0.a)), TuplesKt.to(Integer.valueOf(LIFE_LOG), new EntityClassData(LifeLogEntity.class, LifeLogEntity.CREATOR.getVersion(), f0.a)), TuplesKt.to(Integer.valueOf(USER_PROFILE), new EntityClassData(UserProfileEntity.class, UserProfileEntity.CREATOR.getVersion(), h0.a)), TuplesKt.to(Integer.valueOf(EVENT_TASK), new EntityClassData(EventTaskEntity.class, EventTaskEntity.CREATOR.getVersion(), i0.a)), TuplesKt.to(Integer.valueOf(APP_INFO), new EntityClassData(AppInfoEntity.class, AppInfoEntity.CREATOR.getVersion(), j0.a)), TuplesKt.to(Integer.valueOf(MUSIC), new EntityClassData(MusicEntity.class, MusicEntity.CREATOR.getVersion(), k0.a))});
    }

    private EntityType() {
    }

    public final Map<Integer, EntityClassData<? extends AppEntity>> getClassMap() {
        return classMap;
    }
}
