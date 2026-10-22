package com.obric.memorydata.database.util.file_utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001J\"\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u00012\u0006\u0010\r\u001a\u00020\u0003H\u0080\b¢\u0006\u0004\b\n\u0010\u0011J(\u0010\u000f\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u00012\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u0002H\u0010H\u0080\b¢\u0006\u0004\b\n\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u0016J)\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/ImagePlaceholder;", "", OaidModel.KEY_ID, "", "meta", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getMeta$database_obricRelease", "()Ljava/util/Map;", "setMeta", "key", EventBody.KEY_VALUE, "getMeta", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "default", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "component1", "component2", "component2$database_obricRelease", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9662b;
    private final Map<String, Object> c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/ImagePlaceholder$Companion;", "", "<init>", "()V", "createImagePlaceholder", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/database/util/file_utils/ImagePlaceholder;", "parsePlaceholder", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final String a(q r6) {
            Intrinsics.checkNotNullParameter(r6, TrackerImpl.PARAMS);
            StringBuilder r5 = new StringBuilder();
            r5.append("id=\"" + r6.a() + "\" ");
            Iterator<Map.Entry<String, Object>> r7 = r6.b().entrySet().iterator();
        L4:
            if (r7.hasNext() == false) goto L6;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r5.append(((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin")) + "=\"" + r0.getValue() + "\" ");
            goto L4
        L6:
            String r8 = r5.toString();
            Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
            return "<image " + StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString() + "/>";
        }
    }

    static {
        f9661a = new a(null);
    }

    public q(String r3, Map<String, Object> r4) {
        Map<String, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r5, "meta");
        this.f9662b = r3;
        this.c = r5;
    }

    public /* synthetic */ q(String r2, Map r3, int r4, DefaultConstructorMarker r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    L5:
        this(r2, r6);
    }

    public final String a() {
        return this.f9662b;
    }

    public final Map<String, Object> b() {
        return this.c;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L8;
        return false;
    L8:
        q r6 = (q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f9662b, r6.f9662b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f9662b.hashCode() * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ImagePlaceholder(id=" + this.f9662b + ", meta=" + this.c + ')';
    }
}
