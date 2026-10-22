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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R%\u00102\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002050403¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityType;", "", "()V", "ALARM", "", "ALBUM", "APP_INFO", "AUDITORY_RECORDING", "BROWSER_BOOKMARK", "CALENDAR_EVENT", "CALL_HISTORY", "CLOUD_DOCUMENT", "CONTACT", "COUNTDOWN", "DOUBAO_ACCOUNT", "EVENT_TASK", "FILE", "GROUP_CHAT", "ICALENDAR_PROTOCOL", "IM_CONTACT", "INVALIDATE_ENTITY_TYPE", "LIFE_LOG", "MEMORY_COLLECT_CONTENT", "MEMORY_COLLECT_STORE", "MEMORY_COMMON_TEXT", "MEMORY_EVENT_SCHEDULE", "MEMORY_EVENT_TODO", "MEMORY_INFO_ADDRESS", "MEMORY_INFO_ANNIVERSARY", "MEMORY_INFO_COMMON", "MEMORY_INFO_DOCUMENTS", "MEMORY_INFO_RELATIONSHIP", "MEMORY_ORDER_COMMON", "MEMORY_ORDER_FLIGHT", "MEMORY_ORDER_HOTEL", "MEMORY_ORDER_MOVIE_TICKET", "MEMORY_ORDER_TICKET", "MEMORY_ORDER_TRAIN", "MESSAGE", "MUSIC", "NOTE", "PHOTO", "PHOTO_FACE", "PROACTIVE_MEMORY", "RECORDING", "SCHEDULE", "SIM_CARD", "STOCK", "USER_PROFILE", "WEBSITE", "classMap", "", "Lcom/obric/capabilitykit/entity/app/EntityClassData;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getClassMap", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Parcel, AlarmEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7543a = null;

        static {
            f7543a = new a();
        }

        public a() {
            super(1);
        }

        public final AlarmEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AlarmEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ AlarmEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventTodoMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function1<Parcel, EventTodoMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a0 f7544a = null;

        static {
            f7544a = new a0();
        }

        public a0() {
            super(1);
        }

        public final EventTodoMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventTodoMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ EventTodoMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CountdownEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function1<Parcel, CountdownEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7545a = null;

        static {
            f7545a = new b();
        }

        public b() {
            super(1);
        }

        public final CountdownEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CountdownEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CountdownEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CommonTextMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function1<Parcel, CommonTextMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b0 f7546a = null;

        static {
            f7546a = new b0();
        }

        public b0() {
            super(1);
        }

        public final CommonTextMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CommonTextMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CommonTextMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function1<Parcel, FileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f7547a = null;

        static {
            f7547a = new c();
        }

        public c() {
            super(1);
        }

        public final FileEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new FileEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ FileEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function1<Parcel, ProactiveMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c0 f7548a = null;

        static {
            f7548a = new c0();
        }

        public c0() {
            super(1);
        }

        public final ProactiveMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ProactiveMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ ProactiveMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/WebsiteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function1<Parcel, WebsiteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7549a = null;

        static {
            f7549a = new d();
        }

        public d() {
            super(1);
        }

        public final WebsiteEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new WebsiteEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ WebsiteEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ICSProtocolEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function1<Parcel, ICSProtocolEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d0 f7550a = null;

        static {
            f7550a = new d0();
        }

        public d0() {
            super(1);
        }

        public final ICSProtocolEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ICSProtocolEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ ICSProtocolEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/BrowserBookmarkEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function1<Parcel, BrowserBookmarkEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7551a = null;

        static {
            f7551a = new e();
        }

        public e() {
            super(1);
        }

        public final BrowserBookmarkEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new BrowserBookmarkEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ BrowserBookmarkEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/DoubaoAccountEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function1<Parcel, DoubaoAccountEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e0 f7552a = null;

        static {
            f7552a = new e0();
        }

        public e0() {
            super(1);
        }

        public final DoubaoAccountEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new DoubaoAccountEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ DoubaoAccountEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function1<Parcel, GroupChatEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f7553a = null;

        static {
            f7553a = new f();
        }

        public f() {
            super(1);
        }

        public final GroupChatEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new GroupChatEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ GroupChatEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/LifeLogEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function1<Parcel, LifeLogEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f0 f7554a = null;

        static {
            f7554a = new f0();
        }

        public f0() {
            super(1);
        }

        public final LifeLogEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new LifeLogEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ LifeLogEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CloudDocumentEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function1<Parcel, CloudDocumentEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f7555a = null;

        static {
            f7555a = new g();
        }

        public g() {
            super(1);
        }

        public final CloudDocumentEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CloudDocumentEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CloudDocumentEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function1<Parcel, CallHistoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g0 f7556a = null;

        static {
            f7556a = new g0();
        }

        public g0() {
            super(1);
        }

        public final CallHistoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CallHistoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CallHistoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/StockEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function1<Parcel, StockEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f7557a = null;

        static {
            f7557a = new h();
        }

        public h() {
            super(1);
        }

        public final StockEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new StockEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ StockEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function1<Parcel, UserProfileEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f7558a = null;

        static {
            f7558a = new h0();
        }

        public h0() {
            super(1);
        }

        public final UserProfileEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new UserProfileEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ UserProfileEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function1<Parcel, PhotoFaceEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f7559a = null;

        static {
            f7559a = new i();
        }

        public i() {
            super(1);
        }

        public final PhotoFaceEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new PhotoFaceEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ PhotoFaceEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function1<Parcel, EventTaskEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i0 f7560a = null;

        static {
            f7560a = new i0();
        }

        public i0() {
            super(1);
        }

        public final EventTaskEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventTaskEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ EventTaskEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function1<Parcel, AuditoryRecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f7561a = null;

        static {
            f7561a = new j();
        }

        public j() {
            super(1);
        }

        public final AuditoryRecordingEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AuditoryRecordingEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ AuditoryRecordingEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function1<Parcel, AppInfoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j0 f7562a = null;

        static {
            f7562a = new j0();
        }

        public j0() {
            super(1);
        }

        public final AppInfoEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AppInfoEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ AppInfoEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function1<Parcel, MessageEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f7563a = null;

        static {
            f7563a = new k();
        }

        public k() {
            super(1);
        }

        public final MessageEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new MessageEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ MessageEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/MusicEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function1<Parcel, MusicEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k0 f7564a = null;

        static {
            f7564a = new k0();
        }

        public k0() {
            super(1);
        }

        public final MusicEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new MusicEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ MusicEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<Parcel, OrderFlightMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f7565a = null;

        static {
            f7565a = new l();
        }

        public l() {
            super(1);
        }

        public final OrderFlightMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderFlightMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderFlightMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/SimCardEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function1<Parcel, SimCardEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l0 f7566a = null;

        static {
            f7566a = new l0();
        }

        public l0() {
            super(1);
        }

        public final SimCardEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new SimCardEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ SimCardEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTrainMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function1<Parcel, OrderTrainMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f7567a = null;

        static {
            f7567a = new m();
        }

        public m() {
            super(1);
        }

        public final OrderTrainMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderTrainMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderTrainMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m0 extends Lambda implements Function1<Parcel, PhotoEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m0 f7568a = null;

        static {
            f7568a = new m0();
        }

        public m0() {
            super(1);
        }

        public final PhotoEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new PhotoEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ PhotoEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function1<Parcel, OrderMovieTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f7569a = null;

        static {
            f7569a = new n();
        }

        public n() {
            super(1);
        }

        public final OrderMovieTicketMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderMovieTicketMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderMovieTicketMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n0 extends Lambda implements Function1<Parcel, AlbumEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n0 f7570a = null;

        static {
            f7570a = new n0();
        }

        public n0() {
            super(1);
        }

        public final AlbumEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new AlbumEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ AlbumEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<Parcel, OrderTicketMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f7571a = null;

        static {
            f7571a = new o();
        }

        public o() {
            super(1);
        }

        public final OrderTicketMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderTicketMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderTicketMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ScheduleEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o0 extends Lambda implements Function1<Parcel, ScheduleEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o0 f7572a = null;

        static {
            f7572a = new o0();
        }

        public o0() {
            super(1);
        }

        public final ScheduleEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ScheduleEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ ScheduleEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderHotelMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function1<Parcel, OrderHotelMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f7573a = null;

        static {
            f7573a = new p();
        }

        public p() {
            super(1);
        }

        public final OrderHotelMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderHotelMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderHotelMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p0 extends Lambda implements Function1<Parcel, RecordingEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p0 f7574a = null;

        static {
            f7574a = new p0();
        }

        public p0() {
            super(1);
        }

        public final RecordingEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new RecordingEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ RecordingEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/OrderCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function1<Parcel, OrderCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f7575a = null;

        static {
            f7575a = new q();
        }

        public q() {
            super(1);
        }

        public final OrderCommonMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new OrderCommonMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ OrderCommonMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q0 extends Lambda implements Function1<Parcel, NoteEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q0 f7576a = null;

        static {
            f7576a = new q0();
        }

        public q0() {
            super(1);
        }

        public final NoteEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new NoteEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ NoteEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoDocumentsMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function1<Parcel, InfoDocumentsMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f7577a = null;

        static {
            f7577a = new r();
        }

        public r() {
            super(1);
        }

        public final InfoDocumentsMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoDocumentsMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ InfoDocumentsMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAddressMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function1<Parcel, InfoAddressMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f7578a = null;

        static {
            f7578a = new s();
        }

        public s() {
            super(1);
        }

        public final InfoAddressMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoAddressMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ InfoAddressMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoAnniversaryMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function1<Parcel, InfoAnniversaryMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f7579a = null;

        static {
            f7579a = new t();
        }

        public t() {
            super(1);
        }

        public final InfoAnniversaryMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoAnniversaryMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ InfoAnniversaryMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoRelationshipMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function1<Parcel, InfoRelationshipMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f7580a = null;

        static {
            f7580a = new u();
        }

        public u() {
            super(1);
        }

        public final InfoRelationshipMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoRelationshipMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ InfoRelationshipMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function1<Parcel, ContactEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f7581a = null;

        static {
            f7581a = new v();
        }

        public v() {
            super(1);
        }

        public final ContactEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new ContactEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ ContactEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function1<Parcel, InfoCommonMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f7582a = null;

        static {
            f7582a = new w();
        }

        public w() {
            super(1);
        }

        public final InfoCommonMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new InfoCommonMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ InfoCommonMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function1<Parcel, CollectContentMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final x f7583a = null;

        static {
            f7583a = new x();
        }

        public x() {
            super(1);
        }

        public final CollectContentMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CollectContentMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CollectContentMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function1<Parcel, CollectStoreMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final y f7584a = null;

        static {
            f7584a = new y();
        }

        public y() {
            super(1);
        }

        public final CollectStoreMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new CollectStoreMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ CollectStoreMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/entity/memory/EventScheduleMemoryEntity;", "parcel", "Landroid/os/Parcel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function1<Parcel, EventScheduleMemoryEntity> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z f7585a = null;

        static {
            f7585a = new z();
        }

        public z() {
            super(1);
        }

        public final EventScheduleMemoryEntity a(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new EventScheduleMemoryEntity(r1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ EventScheduleMemoryEntity invoke(Parcel r3) {
            return a((Parcel) ZeusTransformUtils.preCheckCast(r3, Parcel.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        INSTANCE = new EntityType();
        classMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(101, new EntityClassData(MessageEntity.class, MessageEntity.CREATOR.getVersion(), k.f7563a)), TuplesKt.to(201, new EntityClassData(ContactEntity.class, ContactEntity.CREATOR.getVersion(), v.f7581a)), TuplesKt.to(202, new EntityClassData(CallHistoryEntity.class, CallHistoryEntity.CREATOR.getVersion(), g0.f7556a)), TuplesKt.to(204, new EntityClassData(SimCardEntity.class, SimCardEntity.CREATOR.getVersion(), l0.f7566a)), TuplesKt.to(301, new EntityClassData(PhotoEntity.class, PhotoEntity.CREATOR.getVersion(), m0.f7568a)), TuplesKt.to(302, new EntityClassData(AlbumEntity.class, AlbumEntity.CREATOR.getVersion(), n0.f7570a)), TuplesKt.to(401, new EntityClassData(ScheduleEntity.class, ScheduleEntity.CREATOR.getVersion(), o0.f7572a)), TuplesKt.to(501, new EntityClassData(RecordingEntity.class, RecordingEntity.CREATOR.getVersion(), p0.f7574a)), TuplesKt.to(601, new EntityClassData(NoteEntity.class, NoteEntity.CREATOR.getVersion(), q0.f7576a)), TuplesKt.to(701, new EntityClassData(AlarmEntity.class, AlarmEntity.CREATOR.getVersion(), a.f7543a)), TuplesKt.to(702, new EntityClassData(CountdownEntity.class, CountdownEntity.CREATOR.getVersion(), b.f7545a)), TuplesKt.to(Integer.valueOf(FILE), new EntityClassData(FileEntity.class, FileEntity.CREATOR.getVersion(), c.f7547a)), TuplesKt.to(901, new EntityClassData(WebsiteEntity.class, WebsiteEntity.CREATOR.getVersion(), d.f7549a)), TuplesKt.to(902, new EntityClassData(BrowserBookmarkEntity.class, BrowserBookmarkEntity.CREATOR.getVersion(), e.f7551a)), TuplesKt.to(203, new EntityClassData(GroupChatEntity.class, GroupChatEntity.CREATOR.getVersion(), f.f7553a)), TuplesKt.to(1001, new EntityClassData(CloudDocumentEntity.class, CloudDocumentEntity.CREATOR.getVersion(), g.f7555a)), TuplesKt.to(Integer.valueOf(STOCK), new EntityClassData(StockEntity.class, StockEntity.CREATOR.getVersion(), h.f7557a)), TuplesKt.to(303, new EntityClassData(PhotoFaceEntity.class, PhotoFaceEntity.CREATOR.getVersion(), i.f7559a)), TuplesKt.to(502, new EntityClassData(AuditoryRecordingEntity.class, AuditoryRecordingEntity.CREATOR.getVersion(), j.f7561a)), TuplesKt.to(10001, new EntityClassData(OrderFlightMemoryEntity.class, OrderFlightMemoryEntity.CREATOR.getVersion(), l.f7565a)), TuplesKt.to(10002, new EntityClassData(OrderTrainMemoryEntity.class, OrderTrainMemoryEntity.CREATOR.getVersion(), m.f7567a)), TuplesKt.to(10003, new EntityClassData(OrderMovieTicketMemoryEntity.class, OrderMovieTicketMemoryEntity.CREATOR.getVersion(), n.f7569a)), TuplesKt.to(10006, new EntityClassData(OrderTicketMemoryEntity.class, OrderTicketMemoryEntity.CREATOR.getVersion(), o.f7571a)), TuplesKt.to(10004, new EntityClassData(OrderHotelMemoryEntity.class, OrderHotelMemoryEntity.CREATOR.getVersion(), p.f7573a)), TuplesKt.to(10005, new EntityClassData(OrderCommonMemoryEntity.class, OrderCommonMemoryEntity.CREATOR.getVersion(), q.f7575a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_DOCUMENTS), new EntityClassData(InfoDocumentsMemoryEntity.class, InfoDocumentsMemoryEntity.CREATOR.getVersion(), r.f7577a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ADDRESS), new EntityClassData(InfoAddressMemoryEntity.class, InfoAddressMemoryEntity.CREATOR.getVersion(), s.f7578a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_ANNIVERSARY), new EntityClassData(InfoAnniversaryMemoryEntity.class, InfoAnniversaryMemoryEntity.CREATOR.getVersion(), t.f7579a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_RELATIONSHIP), new EntityClassData(InfoRelationshipMemoryEntity.class, InfoRelationshipMemoryEntity.CREATOR.getVersion(), u.f7580a)), TuplesKt.to(Integer.valueOf(MEMORY_INFO_COMMON), new EntityClassData(InfoCommonMemoryEntity.class, InfoCommonMemoryEntity.CREATOR.getVersion(), w.f7582a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_CONTENT), new EntityClassData(CollectContentMemoryEntity.class, CollectContentMemoryEntity.CREATOR.getVersion(), x.f7583a)), TuplesKt.to(Integer.valueOf(MEMORY_COLLECT_STORE), new EntityClassData(CollectStoreMemoryEntity.class, CollectStoreMemoryEntity.CREATOR.getVersion(), y.f7584a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_SCHEDULE), new EntityClassData(EventScheduleMemoryEntity.class, EventScheduleMemoryEntity.CREATOR.getVersion(), z.f7585a)), TuplesKt.to(Integer.valueOf(MEMORY_EVENT_TODO), new EntityClassData(EventTodoMemoryEntity.class, EventTodoMemoryEntity.CREATOR.getVersion(), a0.f7544a)), TuplesKt.to(Integer.valueOf(MEMORY_COMMON_TEXT), new EntityClassData(CommonTextMemoryEntity.class, CommonTextMemoryEntity.CREATOR.getVersion(), b0.f7546a)), TuplesKt.to(Integer.valueOf(PROACTIVE_MEMORY), new EntityClassData(ProactiveMemoryEntity.class, ProactiveMemoryEntity.CREATOR.getVersion(), c0.f7548a)), TuplesKt.to(402, new EntityClassData(ICSProtocolEntity.class, ICSProtocolEntity.CREATOR.getVersion(), d0.f7550a)), TuplesKt.to(Integer.valueOf(DOUBAO_ACCOUNT), new EntityClassData(DoubaoAccountEntity.class, DoubaoAccountEntity.CREATOR.getVersion(), e0.f7552a)), TuplesKt.to(Integer.valueOf(LIFE_LOG), new EntityClassData(LifeLogEntity.class, LifeLogEntity.CREATOR.getVersion(), f0.f7554a)), TuplesKt.to(Integer.valueOf(USER_PROFILE), new EntityClassData(UserProfileEntity.class, UserProfileEntity.CREATOR.getVersion(), h0.f7558a)), TuplesKt.to(Integer.valueOf(EVENT_TASK), new EntityClassData(EventTaskEntity.class, EventTaskEntity.CREATOR.getVersion(), i0.f7560a)), TuplesKt.to(Integer.valueOf(APP_INFO), new EntityClassData(AppInfoEntity.class, AppInfoEntity.CREATOR.getVersion(), j0.f7562a)), TuplesKt.to(Integer.valueOf(MUSIC), new EntityClassData(MusicEntity.class, MusicEntity.CREATOR.getVersion(), k0.f7564a))});
    }

    private EntityType() {
    }

    public final Map<Integer, EntityClassData<? extends AppEntity>> getClassMap() {
        return classMap;
    }
}
