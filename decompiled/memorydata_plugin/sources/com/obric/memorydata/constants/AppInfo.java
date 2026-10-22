package com.obric.memorydata.constants;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006 "}, d2 = {"Lcom/obric/memorydata/constants/AppInfo;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "appName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getPackageName", "()Ljava/lang/String;", "getAppName", "WeiXin", "OAssistant", "OExecutionEngine", "InputMethod", "Gallery", "Contact", "Message", i.H, "Recorder", "AiRecordAssistant", "MeiTuan", "XiaoHongShu", "Calendar", "Alarm", "QQ", "ASSISTANT_AI_AGENT", "OAuto", "FileManager", "QuickSearch", "AppletApp", "Launcher", "Companion", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum AppInfo extends Enum<AppInfo> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppInfo[] $VALUES = null;
    public static final AppInfo ASSISTANT_AI_AGENT = null;
    public static final AppInfo AiRecordAssistant = null;
    public static final AppInfo Alarm = null;
    public static final AppInfo AppletApp = null;
    public static final AppInfo Calendar = null;
    public static final a Companion = null;
    public static final AppInfo Contact = null;
    public static final AppInfo FileManager = null;
    public static final AppInfo Gallery = null;
    public static final AppInfo InputMethod = null;
    public static final AppInfo Launcher = null;
    public static final AppInfo MeiTuan = null;
    public static final AppInfo Message = null;
    public static final AppInfo Note = null;
    public static final AppInfo OAssistant = null;
    public static final AppInfo OAuto = null;
    public static final AppInfo OExecutionEngine = null;
    public static final AppInfo QQ = null;
    public static final AppInfo QuickSearch = null;
    public static final AppInfo Recorder = null;
    public static final AppInfo WeiXin = null;
    public static final AppInfo XiaoHongShu = null;
    private final String appName;
    private final String packageName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/constants/AppInfo$Companion;", "", "<init>", "()V", "contains", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ AppInfo[] $values() {
        return new AppInfo[]{WeiXin, OAssistant, OExecutionEngine, InputMethod, Gallery, Contact, Message, Note, Recorder, AiRecordAssistant, MeiTuan, XiaoHongShu, Calendar, Alarm, QQ, ASSISTANT_AI_AGENT, OAuto, FileManager, QuickSearch, AppletApp, Launcher};
    }

    static {
        WeiXin = new AppInfo("WeiXin", 0, "com.tencent.mm", "微信");
        OAssistant = new AppInfo("OAssistant", 1, "com.larus.nova", "豆包");
        OExecutionEngine = new AppInfo("OExecutionEngine", 2, "com.obric.aiagent.executionengine", "执行引擎");
        InputMethod = new AppInfo("InputMethod", 3, "com.bytedance.android.input", "系统输入法");
        Gallery = new AppInfo("Gallery", 4, "com.android.gallery3d", "相册");
        Contact = new AppInfo("Contact", 5, "com.android.contacts", "电话");
        Message = new AppInfo("Message", 6, "com.android.mms", "短信");
        Note = new AppInfo(i.H, 7, "com.obric.notes", "便签");
        Recorder = new AppInfo("Recorder", 8, "com.obric.recorder", "录音机");
        AiRecordAssistant = new AppInfo("AiRecordAssistant", 9, "com.bytedance.obric.airecordassistant", "AI录音助手");
        MeiTuan = new AppInfo("MeiTuan", 10, "com.sankuai.meituan", "美团");
        XiaoHongShu = new AppInfo("XiaoHongShu", 11, "com.xingin.xhs", "小红书");
        Calendar = new AppInfo("Calendar", 12, "com.obric.calendar", "日历");
        Alarm = new AppInfo("Alarm", 13, "com.obric.clock", "闹钟");
        QQ = new AppInfo("QQ", 14, "com.tencent.mobileqq", "QQ");
        ASSISTANT_AI_AGENT = new AppInfo("ASSISTANT_AI_AGENT", 15, "com.obric.assistantaiagent", "助手");
        OAuto = new AppInfo("OAuto", 16, "com.obric.autoaction", "OAuto");
        FileManager = new AppInfo("FileManager", 17, "com.obric.filemanager", "文件管理器");
        QuickSearch = new AppInfo("QuickSearch", 18, "com.obric.quicksearch", "全局搜索");
        AppletApp = new AppInfo("AppletApp", 19, "com.obric.appletapp", "小程序");
        Launcher = new AppInfo("Launcher", 20, "com.android.launcher3", "系统桌面");
        AppInfo[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private AppInfo(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.packageName = r3;
        this.appName = r4;
    }

    public static EnumEntries<AppInfo> getEntries() {
        return $ENTRIES;
    }

    public static AppInfo valueOf(String r2) {
        return (AppInfo) ZeusTransformUtils.preCheckCast(Enum.valueOf(AppInfo.class, r2), AppInfo.class, "com.obric.memorydata.plugin");
    }

    public static AppInfo[] values() {
        return (AppInfo[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AppInfo[].class, "com.obric.memorydata.plugin");
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }
}
