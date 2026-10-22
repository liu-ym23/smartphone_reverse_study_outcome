package com.obric.memorydata.datatransport.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B]\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lcom/obric/memorydata/datatransport/entity/ConstructedNoteEntity;", "Lcom/obric/memorydata/datatransport/entity/ConstructedAppEntity;", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "title", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "formatMode", "noteFolder", "isFavorite", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTitle", "()Ljava/lang/String;", "getText", "getFormatMode", "setFormatMode", "(Ljava/lang/String;)V", "getNoteFolder", "setNoteFolder", "()Z", "setFavorite", "(Z)V", "toOriginalAppEntity", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "mapStringToFormatModeEnum", "Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", TypedValues.Custom.S_STRING, "generateEvaluationId", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9721b;
    private final String c;
    private String d;
    private String e;
    private boolean f;

    public final FormatModeEnum a(String r1) {
        if (Intrinsics.areEqual(r1, "Markdown") == false) goto L6;
        return FormatModeEnum.MARKDOWN;
    L6:
        if (Intrinsics.areEqual(r1, "RTF") == true) goto L11;
        return null;
    L11:
        return FormatModeEnum.RTF;
    }

    @Override // com.obric.memorydata.datatransport.a.a
    public /* synthetic */ AppEntity d() {
        return (AppEntity) ZeusTransformUtils.preCheckCast(e(), AppEntity.class, "com.obric.memorydata.plugin");
    }

    public NoteEntity e() {
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
        if (r5 == null) goto L13;
        r3 = r5.longValue();
    L13:
        return new NoteEntity(r1, r4, r3, this.f9721b, this.c, a(this.d), this.e, this.f);
    L8:
        r4 = 0;
        goto L9
    }
}
