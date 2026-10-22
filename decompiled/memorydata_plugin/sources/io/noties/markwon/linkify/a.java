package io.noties.markwon.linkify;

import androidx.core.util.PatternsCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.k;
import io.noties.markwon.n;
import io.noties.markwon.t;
import io.noties.markwon.w;
import io.noties.markwon.x;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "()V", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "InlineLinkifyParser", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
public class a extends io.noties.markwon.a {

    /* JADX INFO: renamed from: io.noties.markwon.linkify.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser;", "Lio/noties/markwon/core/CorePlugin$OnTextAddedListener;", "()V", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", "Companion", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
    public static class C0867a implements io.noties.markwon.core.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f16643a = "(https?:\\/\\/)?";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0868a f16644b = null;
        private static final String c = "[a-zA-Z@]+(\\.[-\\da-zA-Z@:]+)*\\.([a-zA-Z]{2,6})";
        private static final Pattern d = null;
        private static final String e = "(:\\d+)?";
        private static final String f = "(\\/[\\da-zA-Z-%\\$.~:_()+!]*)*";
        private static final String g = "(\\?[\\da-zA-Z-@%.&()=+!{}|;^_]*)?";
        private static final String h = "(#[\\da-zA-Z-@%.&()=+!{}|;^_]*)?";
        private static final Pattern i = null;

        /* JADX INFO: renamed from: io.noties.markwon.linkify.a$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\f¨\u0006\u0018"}, d2 = {"Lio/noties/markwon/linkify/LinkifyPlugin2$InlineLinkifyParser$Companion;", "", "()V", "fragment", "", "getFragment", "()Ljava/lang/String;", "host", "getHost", "ip", "Ljava/util/regex/Pattern;", "getIp", "()Ljava/util/regex/Pattern;", "path", "getPath", "port", "getPort", ChatMessage.TYPE_QUERY, "getQuery", "scheme", "getScheme", "urlPattern", "urlPattern$annotations", "getUrlPattern", "markwon-linkify_release"}, k = 1, mv = {1, 1, 15})
        public static final class C0868a {
            private C0868a() {
            }

            public /* synthetic */ C0868a(DefaultConstructorMarker r1) {
                this();
            }

            public final Pattern a() {
                return C0867a.a();
            }
        }

        static {
            f16644b = new C0868a(null);
            f16643a = "(https?:\\/\\/)?";
            c = "[a-zA-Z@]+(\\.[-\\da-zA-Z@:]+)*\\.([a-zA-Z]{2,6})";
            Pattern r2 = PatternsCompat.IP_ADDRESS;
            if (r2 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            d = r2;
            e = "(:\\d+)?";
            f = "(\\/[\\da-zA-Z-%\\$.~:_()+!]*)*";
            g = "(\\?[\\da-zA-Z-@%.&()=+!{}|;^_]*)?";
            h = "(#[\\da-zA-Z-@%.&()=+!{}|;^_]*)?";
            Pattern r0 = Pattern.compile("(https?:\\/\\/)?([a-zA-Z@]+(\\.[-\\da-zA-Z@:]+)*\\.([a-zA-Z]{2,6})|" + r2 + ")(:\\d+)?(\\/[\\da-zA-Z-%\\$.~:_()+!]*)*(\\?[\\da-zA-Z-@%.&()=+!{}|;^_]*)?(#[\\da-zA-Z-@%.&()=+!{}|;^_]*)?");
            Intrinsics.checkExpressionValueIsNotNull(r0, "Pattern.compile(\"$scheme…ort$path$query$fragment\")");
            i = r0;
        }

        public C0867a() {
        }

        public static final /* synthetic */ Pattern a() {
            return i;
        }

        @Override // io.noties.markwon.core.a.b
        public void a(n r8, String r9, int r10) {
            n r7 = (n) ZeusTransformUtils.wrapperContextForParams(r8, n.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r7, "visitor");
            Intrinsics.checkParameterIsNotNull(r9, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            w r11 = r7.a().f().a(Link.class);
            if (r11 == null) goto L10;
            Intrinsics.checkExpressionValueIsNotNull(r11, "visitor.configuration().…nk::class.java) ?: return");
            Matcher r12 = i.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"));
        L6:
            if (r12.find() == false) goto L16;
            int r1 = r12.start();
            int r2 = r12.end();
            String r3 = r12.group();
            if (PatternsCompat.EMAIL_ADDRESS.matcher((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).find() == true) goto L6;
            t r4 = r7.b();
            Intrinsics.checkExpressionValueIsNotNull(r4, "visitor.renderProps()");
            x r5 = r7.c();
            Intrinsics.checkExpressionValueIsNotNull(r5, "visitor.builder()");
            CoreProps.g.b(r4, r3);
            x.a(r5, r11.a(r7.a(), r4), r1 + r10, r2 + r10);
            goto L6
        L16:
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "corePlugin", "Lio/noties/markwon/core/CorePlugin;", "apply"}, k = 3, mv = {1, 1, 15})
    static final class b<P extends k> implements k.a<io.noties.markwon.core.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16645a = null;

        static {
            f16645a = new b();
        }

        b() {
        }

        public final void a(io.noties.markwon.core.a r3) {
            Intrinsics.checkParameterIsNotNull(r3, "corePlugin");
            r3.a((io.noties.markwon.core.a.b) ZeusTransformUtils.preCheckCast(new C0867a(), io.noties.markwon.core.a.b.class, "com.obric.memorydata.plugin"));
        }

        @Override // io.noties.markwon.k.a
        public /* synthetic */ void a(k r3) {
            a((io.noties.markwon.core.a) ZeusTransformUtils.preCheckCast((k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.memorydata.plugin"), io.noties.markwon.core.a.class, "com.obric.memorydata.plugin"));
        }
    }

    public a() {
    }

    @Override // io.noties.markwon.a, io.noties.markwon.k
    public void a(k.b r4) {
        k.b r3 = (k.b) ZeusTransformUtils.wrapperContextForParams(r4, k.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "registry");
        r3.a(io.noties.markwon.core.a.class, (k.a) ZeusTransformUtils.preCheckCast(b.f16645a, k.a.class, "com.obric.memorydata.plugin"));
    }
}
