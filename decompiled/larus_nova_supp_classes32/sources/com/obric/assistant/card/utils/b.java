package com.obric.assistant.card.utils;

import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import com.larus.deeplink.api.IDeeplinkService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.EventTaskEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "phoneNumber");
        String r8 = StringsKt.replace$default(r7, " ", NameKeys.UnloadStrategy_No_Strategy, false, 4, null);
        AppHost.Companion r0 = AppHost.a;
        TelephonyManager r1 = (TelephonyManager) r0.getApplication().getSystemService(TelephonyManager.class);
        if (r1 != null) goto L7;
        FLogger.a.e("AppEntityEx", "Failed to get TelephonyManager");
        return;
    L7:
        if (r1.getSimState() != 1) goto L10;
        FLogger.a.w("AppEntityEx", "SIM card not present");
        Toast.makeText(r0.getApplication(), 2131912274, 0).show();
        return;
    L10:
        IAgentAppIntentIDL r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r2 == null) goto L14;
        r2.callPhone(r8, null, null, null);
        return;
    }

    public static final void c(AppEntity r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        FLogger r1 = FLogger.a;
        r1.i("AppEntityEx", "gotoShow: " + Reflection.getOrCreateKotlinClass(r8.getClass()).getSimpleName());
        if ((r8 instanceof AlarmEntity) == false) goto L8;
        IAgentAppIntentIDL r0 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r0 == null) goto L112;
        r0.showAlarm((AlarmEntity) r8);
        return;
    L112:
        return;
    L8:
        if ((r8 instanceof CallHistoryEntity) == false) goto L13;
        IAgentAppIntentIDL r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r2 == null) goto L114;
        r2.showCallHistory((CallHistoryEntity) r8);
        return;
    L114:
        return;
    L13:
        if ((r8 instanceof ContactEntity) == false) goto L18;
        IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r3 == null) goto L116;
        r3.showContact((ContactEntity) r8);
        return;
    L116:
        return;
    L18:
        if ((r8 instanceof CountdownEntity) == false) goto L23;
        IAgentAppIntentIDL r4 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r4 == null) goto L118;
        r4.showCountdown((CountdownEntity) r8);
        return;
    L118:
        return;
    L23:
        if ((r8 instanceof NoteEntity) == false) goto L28;
        IAgentAppIntentIDL r5 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r5 == null) goto L120;
        r5.showNote((NoteEntity) r8);
        return;
    L120:
        return;
    L28:
        if ((r8 instanceof AlbumEntity) == false) goto L32;
        IAgentAppIntentIDL r6 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r6 == null) goto L122;
        r6.showAlbum((AlbumEntity) r8);
        return;
    L122:
        return;
    L32:
        boolean r7 = false;
        if ((r8 instanceof PhotoEntity) == false) goto L38;
        IAgentAppIntentIDL r9 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r9 == null) goto L124;
        r9.showPhoto((PhotoEntity[]) CollectionsKt.listOf(r8).toArray(new PhotoEntity[0]), 0);
        return;
    L124:
        return;
    L38:
        if ((r8 instanceof FileEntity) == false) goto L43;
        IAgentAppIntentIDL r10 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r10 == null) goto L126;
        r10.showFile((FileEntity) r8);
        return;
    L126:
        return;
    L43:
        if ((r8 instanceof RecordingEntity) == false) goto L48;
        IAgentAppIntentIDL r11 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r11 == null) goto L128;
        r11.showRecording((RecordingEntity) r8);
        return;
    L128:
        return;
    L48:
        if ((r8 instanceof MessageEntity) == false) goto L52;
        IAgentAppIntentIDL r12 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r12 == null) goto L130;
        r12.showMessage((MessageEntity) r8);
        return;
    L130:
        return;
    L52:
        Boolean r13 = null;
        if ((r8 instanceof ScheduleEntity) == false) goto L89;
        ScheduleEntity r14 = (ScheduleEntity) r8;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        if (r14.getCalendarType() == null) goto L57;
        r7 = true;
    L57:
        if (r7 == false) goto L85;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r15 = r14.getIcsId();
        String r16 = NameKeys.UnloadStrategy_No_Strategy;
        if (r15 != null) goto L61;
        r15 = NameKeys.UnloadStrategy_No_Strategy;
    L61:
        String r17 = r14.getRecurrenceId();
        if (r17 == null) goto L65;
        r16 = r17;
    L65:
        Long r18 = r14.getJumpCalendarPageStartTimeStamp();
        r1.i("AppEntityEx", "getCalendarMiniAppJumpLink: icsId = " + r15 + ", recurrenceId = " + r16 + ", jumpCalendarPageStartTimeStamp = " + r18);
        JSONObject r19 = new JSONObject();
        r19.put("source", "personalContext");
        r19.put("eventUuid", r15);
        if (o0.d(r16) == false) goto L68;
        r19.put("recurrenceId", r16);
    L68:
        if (r18 == null) goto L70;
        r19.put("dtstart", r18.longValue());
    L70:
        String r20 = "sslocal://flow/open_applet?appletId=com.flow.calendar&pageId=event&pageType=full&pageData=" + URLEncoder.encode(r19.toString(), StandardCharsets.UTF_8.toString());
        r1.i("AppEntityEx", "jumpUrl = " + r20);
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L76
        IDeeplinkService r22 = (IDeeplinkService) ServiceManager.get().getService(IDeeplinkService.class);     // Catch: Throwable -> L76
        if (r22 == null) goto L74;
        r13 = Boolean.valueOf(r22.i(AppHost.a.getApplication(), UriProtector.parse(r20)));     // Catch: Throwable -> L76
    L74:
        Object r23 = Result.constructor-impl(r13);     // Catch: Throwable -> L76
    L78:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L82;
        FLogger.a.w("AppEntityEx", "routerFromXOpen failed: " + r24.getMessage(), r24);
    L82:
        if (Result.isSuccess-impl(r23) == false) goto L84;
        FLogger.a.w("AppEntityEx", "routerFromXOpen success: result = " + ((Boolean) r23));
    L84:
        Result.box-impl(r23);
        return;
    L76:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L85:
        IAgentAppIntentIDL r26 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r26 == null) goto L133;
        r26.showSchedule(r14);
        return;
    L133:
        return;
    L89:
        if ((r8 instanceof AuditoryRecordingEntity) == false) goto L94;
        IAgentAppIntentIDL r27 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r27 == null) goto L135;
        r27.showAuditoryRecording((AuditoryRecordingEntity) r8);
        return;
    L135:
        return;
    L94:
        if ((r8 instanceof ProactiveMemoryEntity) == false) goto L99;
        IAgentAppIntentIDL r28 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r28 == null) goto L137;
        r28.showProactiveMemory((ProactiveMemoryEntity) r8);
        return;
    L137:
        return;
    L99:
        if ((r8 instanceof EventTaskEntity) == false) goto L104;
        IAgentTaskAppIDL r29 = s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));
        if (r29 == null) goto L139;
        r29.openEventTaskDetailPage(r8.getId(), null);
        return;
    L139:
        return;
    L104:
        if ((r8 instanceof MemoryEntity) == false) goto L108;
        IAgentAppIntentIDL r30 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r30 == null) goto L141;
        r30.showMemory((MemoryEntity) r8);
        return;
    L141:
        return;
    L108:
        r1.w("AppEntityEx", "unsupported entity: " + r8);
    }

    public static final boolean d(List<? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((!r4.isEmpty()) == true) goto L5;
    L24:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L21;
        Iterator<T> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L21;
        Object r0 = r5.next();
        if ((r0 instanceof EventTaskEntity) == false) goto L13;
    L18:
        boolean r1 = true;
    L19:
        if (r1 == true) goto L9;
        boolean r6 = false;
    L22:
        if (r6 == false) goto L24;
        return true;
    L13:
        if ((r0 instanceof AlarmEntity) == true) goto L18;
        if ((r0 instanceof NoteEntity) == true) goto L18;
        r1 = false;
    L21:
        r6 = true;
        goto L22
    }

    public static final boolean b(List<? extends Object> r14, Object r15) {
        Intrinsics.checkNotNullParameter(r15, "item");
        List<? extends Object> r0 = r14;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return false;
    L11:
        boolean r2 = r15 instanceof PhotoEntity;
        if (r2 == false) goto L34;
        int r3 = r14.indexOf(r15);
        ArrayList r13 = new ArrayList();
        if (r2 == false) goto L16;
        r13.add(r15);
    L16:
        int r4 = r3 - 1;
    L17:
        if (r4 < 0) goto L21;
        Object r5 = ListProtector.get(r14, r4);
        if ((r5 instanceof PhotoEntity) == false) goto L21;
        ListProtector.add(r13, 0, r5);
        r4 = r4 - 1;
    L21:
        int r6 = r3 + 1;
    L23:
        if (r6 >= r14.size()) goto L27;
        Object r7 = ListProtector.get(r14, r6);
        if ((r7 instanceof PhotoEntity) == false) goto L27;
        r13.add(r7);
        r6 = r6 + 1;
    L27:
        int r16 = r13.indexOf(r15);
        if (r16 >= 0) goto L30;
        r16 = 0;
    L30:
        FLogger.a.i("AppEntityEx", "showPhoto: index = " + r16 + ", groupSize = " + r13.size() + ", groupList = " + CollectionsKt.joinToString$default(r13, null, null, null, 0, null, new a(), 31, null));
        IAgentAppIntentIDL r17 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r17 == null) goto L33;
        r17.showPhoto((PhotoEntity[]) r13.toArray(new PhotoEntity[0]), r16);
    L33:
        return true;
    L34:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
