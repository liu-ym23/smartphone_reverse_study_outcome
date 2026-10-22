package com.ivy.ivykit.api.plugin.debug;

import android.content.Context;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001e\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\u000f\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService;", "", "", "enable", "", "setEnable", "(Z)V", "isEnable", "()Z", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", "context", "scanCallback", "registerScanCallback", "(Lkotlin/jvm/functions/Function1;)V", "", "schema", "handleSchema", "(Ljava/lang/String;)Z", "Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$LogLevel;", "level", "type", "tag", "msg", "extra", "log", "(Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$LogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "com/ivy/ivykit/api/plugin/debug/a", "LogLevel", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IvyDebugService {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/ivy/ivykit/api/plugin/debug/IvyDebugService$LogLevel;", "", "ivy_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum LogLevel extends Enum<LogLevel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LogLevel[] f9486a = null;

        static {
            f9486a = new LogLevel[]{new LogLevel("VERBOSE", 0), new LogLevel("DEBUG", 1), new LogLevel("INFO", 2), new LogLevel("WARN", 3), new LogLevel("ERROR", 4)};
        }

        public LogLevel(String r5, int r10) {
            super(r5, r10);
        }

        public static LogLevel valueOf(String r5) {
            return (LogLevel) Enum.valueOf(LogLevel.class, r5);
        }

        public static LogLevel[] values() {
            return (LogLevel[]) f9486a.clone();
        }
    }

    static {
        Companion = a.f9487a;
    }

    boolean handleSchema(String r5);

    boolean isEnable();

    void log(LogLevel r5, String r10, String r11, Object r12, Object r13);

    void registerScanCallback(Function1<? super Context, Unit> r5);

    void setEnable(boolean r5);
}
