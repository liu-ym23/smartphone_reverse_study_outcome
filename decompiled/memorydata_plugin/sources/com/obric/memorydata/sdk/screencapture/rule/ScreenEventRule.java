package com.obric.memorydata.sdk.screencapture.rule;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0006\u0010\u001f\u001a\u00020\nJ\u001c\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H&J!\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020%H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR.\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "Landroid/os/Parcelable;", "<init>", "()V", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "targetPackages", "", "", "getTargetPackages", "()Ljava/util/List;", "setTargetPackages", "(Ljava/util/List;)V", "blackPackages", "getBlackPackages", "setBlackPackages", "blackActivityPrefixes", "", "getBlackActivityPrefixes", "()Ljava/util/Map;", "setBlackActivityPrefixes", "(Ljava/util/Map;)V", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "toJson", "isMatch", "", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "context", "Landroid/content/Context;", "isFilter", "pkg", "isFilter$memoryDataSDK_obricRelease", "getCurrentForegroundActivityName", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ScreenEventRule implements Parcelable {
    public static final a Companion = null;
    private static final String TAG = "ScreenEventRule";
    private static final Map<ScreenEvent.EventType, Class<? extends ScreenEventRule>> eventTypeClassMap = null;
    private static final Gson gson = null;
    private Map<String, ? extends List<String>> blackActivityPrefixes;
    private List<String> blackPackages;
    private List<String> targetPackages;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule$Companion;", "", "<init>", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "eventTypeClassMap", "", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "Ljava/lang/Class;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "fromJson", "json", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Gson a() {
            return ScreenEventRule.access$getGson$cp();
        }

        public final ScreenEventRule a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "json");
            String r4 = new JSONObject(r5).optString("eventType");
            Intrinsics.checkNotNull(r4);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == false) goto L11;
            String r6 = "eventType is empty";
        L9:
            Log.e(ScreenEventRule.TAG, r6);
            return null;
        L11:
            ScreenEvent.EventType r7 = ScreenEvent.EventType.valueOf(r4);
            Class r8 = (Class) ZeusTransformUtils.preCheckCast(ScreenEventRule.access$getEventTypeClassMap$cp().get(r7), Class.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L15;
            r6 = "eventTypeClass is null";
            goto L9
        L15:
            return (ScreenEventRule) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r5, r8), ScreenEventRule.class, "com.obric.memorydata.plugin");
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
        Companion = new a(null);
        Gson r0 = new GsonBuilder().registerTypeAdapter((Type) ZeusTransformUtils.preCheckCast(ScreenEventRule.class, Type.class, "com.obric.memorydata.plugin"), new ScreenEventRuleDeserializerTypeAdapter()).create();
        Intrinsics.checkNotNull(r0);
        gson = r0;
        eventTypeClassMap = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ScreenEvent.EventType.TOUCH, ScreenTouchEventRule.class), TuplesKt.to(ScreenEvent.EventType.INPUT_METHOD, InputMethodEventRule.class), TuplesKt.to(ScreenEvent.EventType.APP_STATE, AppStateEventRule.class), TuplesKt.to(ScreenEvent.EventType.ACCESSIBILITY, AppAccessibilityEventRule.class)});
    }

    public ScreenEventRule() {
    }

    public static final /* synthetic */ Map access$getEventTypeClassMap$cp() {
        return eventTypeClassMap;
    }

    public static final /* synthetic */ Gson access$getGson$cp() {
        return gson;
    }

    private final String getCurrentForegroundActivityName(Context r3) {
        Object r2 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r4 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r2, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(1);
        Intrinsics.checkNotNull(r4);
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L8;
        ComponentName r5 = ((ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r4.get(0), ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin")).topActivity;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getClassName();
    L8:
        return null;
    }

    public static /* synthetic */ boolean isFilter$memoryDataSDK_obricRelease$default(ScreenEventRule r2, String r3, Context r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.isFilter$memoryDataSDK_obricRelease(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isFilter");
    }

    public static /* synthetic */ boolean isMatch$default(ScreenEventRule r2, ScreenEvent r3, Context r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L8;
        r7 = null;
    L8:
        return r2.isMatch(r3, r7);
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isMatch");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, List<String>> getBlackActivityPrefixes() {
        return this.blackActivityPrefixes;
    }

    public List<String> getBlackPackages() {
        return this.blackPackages;
    }

    public abstract ScreenEvent.EventType getEventType();

    public List<String> getTargetPackages() {
        return this.targetPackages;
    }

    public final boolean isFilter$memoryDataSDK_obricRelease(String r6, Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "pkg");
        if (getBlackPackages() == null) goto L8;
        List<String> r0 = getBlackPackages();
        Intrinsics.checkNotNull(r0);
        if (r0.contains(r6) == false) goto L8;
        return true;
    L8:
        if (getTargetPackages() == null) goto L13;
        List<String> r1 = getTargetPackages();
        Intrinsics.checkNotNull(r1);
        if (r1.contains(r6) == true) goto L13;
        return true;
    L13:
        if (getBlackActivityPrefixes() == null) goto L25;
        if (r8 == null) goto L25;
        Map<String, List<String>> r2 = getBlackActivityPrefixes();
        Intrinsics.checkNotNull(r2);
        List r9 = (List) ZeusTransformUtils.preCheckCast(r2.get(r6), List.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L25;
        String r5 = getCurrentForegroundActivityName(r8);
        if (r5 == null) goto L25;
        Iterator r10 = r9.iterator();
    L21:
        if (r10.hasNext() == false) goto L25;
        if (StringsKt.startsWith$default(r5, (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L21;
        return true;
    L25:
        return false;
    }

    public abstract boolean isMatch(ScreenEvent r1, Context r2);

    public void setBlackActivityPrefixes(Map<String, ? extends List<String>> r3) {
        this.blackActivityPrefixes = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void setBlackPackages(List<String> r3) {
        this.blackPackages = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setTargetPackages(List<String> r3) {
        this.targetPackages = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final String toJson() {
        String r1 = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(toJson());
    }
}
