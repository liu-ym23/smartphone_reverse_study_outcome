package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.MusicEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.app.SimCardEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityHashCodeGeneratorMapping;", "", "()V", "hashCodeMapping", "", "", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "getHashCodeMapping$capabilitykitcommon_release", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f7525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, b0> f7526b = null;

    static {
        f7525a = new w();
        LinkedHashMap r0 = new LinkedHashMap();
        f7526b = r0;
        String r1 = AuditoryRecordingEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "AuditoryRecordingEntity::class.java.name");
        r0.put(r1, n.f7514a);
        String r2 = AlarmEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "AlarmEntity::class.java.name");
        r0.put(r2, j.f7506a);
        String r3 = UserProfileEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "UserProfileEntity::class.java.name");
        r0.put(r3, n0.f7515a);
        String r4 = CallHistoryEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "CallHistoryEntity::class.java.name");
        r0.put(r4, p.f7518a);
        String r5 = AppInfoEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "AppInfoEntity::class.java.name");
        r0.put(r5, m.f7512a);
        String r6 = FileEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "FileEntity::class.java.name");
        r0.put(r6, y.f7529a);
        String r7 = RecordingEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "RecordingEntity::class.java.name");
        r0.put(r7, j0.f7507a);
        String r8 = StockEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r8, "StockEntity::class.java.name");
        r0.put(r8, m0.f7513a);
        String r9 = ProactiveMemoryEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "ProactiveMemoryEntity::class.java.name");
        r0.put(r9, i0.f7504a);
        String r10 = SimCardEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "SimCardEntity::class.java.name");
        r0.put(r10, l0.f7511a);
        String r11 = NoteEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "NoteEntity::class.java.name");
        r0.put(r11, f0.f7497a);
        String r12 = MessageEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "MessageEntity::class.java.name");
        r0.put(r12, d0.f7495a);
        String r13 = CountdownEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "CountdownEntity::class.java.name");
        r0.put(r13, u.f7523a);
        String r14 = MusicEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "MusicEntity::class.java.name");
        r0.put(r14, e0.f7496a);
        String r15 = DoubaoAccountEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "DoubaoAccountEntity::class.java.name");
        r0.put(r15, v.f7524a);
        String r16 = WebsiteEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r16, "WebsiteEntity::class.java.name");
        r0.put(r16, o0.f7517a);
        String r17 = AlbumEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r17, "AlbumEntity::class.java.name");
        r0.put(r17, k.f7508a);
        String r18 = GroupChatEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "GroupChatEntity::class.java.name");
        r0.put(r18, z.f7530a);
        String r19 = ContactEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r19, "ContactEntity::class.java.name");
        r0.put(r19, t.f7522a);
        String r20 = LifeLogEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r20, "LifeLogEntity::class.java.name");
        r0.put(r20, c0.f7492a);
        String r21 = BrowserBookmarkEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r21, "BrowserBookmarkEntity::class.java.name");
        r0.put(r21, o.f7516a);
        String r22 = PhotoFaceEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r22, "PhotoFaceEntity::class.java.name");
        r0.put(r22, h0.f7503a);
        String r23 = ScheduleEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r23, "ScheduleEntity::class.java.name");
        r0.put(r23, k0.f7509a);
        String r24 = CloudDocumentEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r24, "CloudDocumentEntity::class.java.name");
        r0.put(r24, q.f7519a);
        String r25 = ICSProtocolEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r25, "ICSProtocolEntity::class.java.name");
        r0.put(r25, a0.f7487a);
        String r26 = PhotoEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r26, "PhotoEntity::class.java.name");
        r0.put(r26, g0.f7502a);
    }

    private w() {
    }

    public final Map<String, b0> a() {
        return f7526b;
    }
}
