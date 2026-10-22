package io.noties.a.a;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public abstract class t {
    public static io.noties.a.h.a a(io.noties.a.h r18) {
        io.noties.a.h.f r1 = io.noties.a.h.a("entity", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("&#?[\\da-z]{1,8};", 2))});
        return io.noties.a.h.a("markup", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<!--[\\s\\S]*?-->"))}), io.noties.a.h.a("prolog", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<\\?[\\s\\S]+?\\?>"))}), io.noties.a.h.a("doctype", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<!DOCTYPE[\\s\\S]+?>", 2))}), io.noties.a.h.a("cdata", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<!\\[CDATA\\[[\\s\\S]*?]]>", 2))}), io.noties.a.h.a(LocationMonitorConst.TAG, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<\\/?(?!\\d)[^\\s>\\/=$<%]+(?:\\s+[^\\s>\\/=]+(?:=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+))?)*\\s*\\/?>", 2), false, true, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a(LocationMonitorConst.TAG, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^<\\/?[^\\s>\\/]+", 2), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^<\\/?"))}), io.noties.a.h.a("namespace", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[^\\s>\\/:]+:"))})}))}), io.noties.a.h.a("attr-value", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+)", 2), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^=")), io.noties.a.h.a(Pattern.compile("(^|[^\\\\])[\"']"), true)}), r1}))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\/?>"))}), io.noties.a.h.a("attr-name", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[^\\s>\\/]+"), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("namespace", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[^\\s>\\/:]+:"))})}))})}))}), r1});
    }
}
