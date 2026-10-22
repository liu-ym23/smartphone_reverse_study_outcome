package okhttp3;

import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.ChatMessage;
import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", ChatMessage.TYPE_QUERY, "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", ActivityLifecycle.NAME, "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", "uri", "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
public final class HttpUrl {
    public static final Companion Companion = null;
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006W"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", ActivityLifecycle.NAME, EventBody.KEY_VALUE, "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", "base", "parse$okhttp", "password", "pop", "", "push", "pos", "limit", "addTrailingSlash", ChatMessage.TYPE_QUERY, "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Builder {
        public static final Companion Companion = null;
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername;
        private String host;
        private int port;
        private String scheme;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 1, 15})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public static final /* synthetic */ int access$parsePort(Companion r0, String r1, int r2, int r3) {
                return r0.parsePort(r1, r2, r3);
            }

            public static final /* synthetic */ int access$portColonOffset(Companion r0, String r1, int r2, int r3) {
                return r0.portColonOffset(r1, r2, r3);
            }

            public static final /* synthetic */ int access$schemeDelimiterOffset(Companion r0, String r1, int r2, int r3) {
                return r0.schemeDelimiterOffset(r1, r2, r3);
            }

            public static final /* synthetic */ int access$slashCount(Companion r0, String r1, int r2, int r3) {
                return r0.slashCount(r1, r2, r3);
            }

            private final int parsePort(String r13, int r14, int r15) {
                int r16 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, r14, r15, "", false, false, false, false, null, 248, null));     // Catch: NumberFormatException -> L10
                if (1 > r16) goto L14;
                if (65535 >= r16) goto L9;
                return -1;
            L9:
                return r16;
            L14:
                return -1;
            L15:
                return -1;
            }

            private final int portColonOffset(String r2, int r3, int r4) {
            L2:
                if (r3 >= r4) goto L14;
                char r1 = r2.charAt(r3);
                if (r1 == ':') goto L13;
                if (r1 != '[') goto L12;
            L8:
                r3 = r3 + 1;
                if (r3 >= r4) goto L12;
                if (r2.charAt(r3) != ']') goto L8;
            L12:
                r3 = r3 + 1;
                goto L2
            L13:
                return r3;
            L14:
                return r4;
            }

            private final int schemeDelimiterOffset(String r8, int r9, int r10) {
                if ((r10 - r9) >= 2) goto L5;
                return -1;
            L5:
                char r7 = r8.charAt(r9);
                if (r7 < 'a') goto L8;
                if (r7 > 'z') goto L8;
            L11:
                r9 = r9 + 1;
                if (r9 >= r10) goto L61;
                char r11 = r8.charAt(r9);
                if ('a' > r11) goto L18;
                if ('z' >= r11) goto L11;
            L18:
                if ('A' > r11) goto L23;
                if ('Z' >= r11) goto L11;
            L23:
                if ('0' > r11) goto L28;
                if ('9' >= r11) goto L11;
            L28:
                if (r11 == '+') goto L11;
                if (r11 == '-') goto L11;
                if (r11 == '.') goto L11;
                if (r11 == ':') goto L39;
                return -1;
            L39:
                return r9;
            L61:
                return -1;
            L8:
                if (r7 < 'A') goto L58;
                if (r7 <= 'Z') goto L11;
                return -1;
            L58:
                return -1;
            }

            private final int slashCount(String r3, int r4, int r5) {
                int r2 = 0;
            L3:
                if (r4 >= r5) goto L9;
                char r0 = r3.charAt(r4);
                if (r0 == '\\') goto L8;
                if (r0 != '/') goto L9;
            L8:
                r2 = r2 + 1;
                r4 = r4 + 1;
            L9:
                return r2;
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Builder() {
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            this.encodedPathSegments = r1;
            r1.add("");
        }

        private final Builder addPathSegments(String r12, boolean r13) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r5 = 0;
        L3:
            int r10 = Util.delimiterOffset(r12, "/\\", r5, r12.length());
            if (r10 >= r12.length()) goto L6;
            boolean r7 = true;
        L7:
            r2.push(r12, r5, r10, r7, r13);
            r5 = r10 + 1;
            if (r5 <= r12.length()) goto L3;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L6:
            r7 = false;
            goto L7
        }

        private final int effectivePort() {
            int r0 = this.port;
            if (r0 != (-1)) goto L10;
            Companion r1 = HttpUrl.Companion;
            String r2 = this.scheme;
            if (r2 != null) goto L9;
            Intrinsics.throwNpe();
        L9:
            return r1.defaultPort(r2);
        L10:
            return r0;
        }

        private final boolean isDot(String r2) {
            if (Intrinsics.areEqual(r2, ".") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r2, "%2e", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        private final boolean isDotDot(String r2) {
            if (Intrinsics.areEqual(r2, "..") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r2, "%2e.", true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(r2, ".%2e", true) == false) goto L9;
            return true;
        L9:
            if (StringsKt.equals(r2, "%2e%2e", true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private final void pop() {
            List<String> r0 = this.encodedPathSegments;
            if (((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r0.remove(r0.size() - 1), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L9;
        L11:
            this.encodedPathSegments.add("");
            return;
        L9:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.encodedPathSegments, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L11;
            List<String> r5 = this.encodedPathSegments;
            r5.set(r5.size() - 1, "");
            return;
        L5:
            r1 = false;
            goto L7
        }

        private final void push(String r14, int r15, int r16, boolean r17, boolean r18) {
            String r1 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, r15, r16, HttpUrl.PATH_SEGMENT_ENCODE_SET, r18, false, false, false, null, 240, null);
            if (isDot(r1) == false) goto L6;
            return;
        L6:
            if (isDotDot(r1) == false) goto L9;
            pop();
            return;
        L9:
            List<String> r2 = this.encodedPathSegments;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            List<String> r4 = this.encodedPathSegments;
            r4.set(r4.size() - 1, r1);
        L16:
            if (r17 == false) goto L19;
            this.encodedPathSegments.add("");
            return;
        L19:
            return;
        L15:
            this.encodedPathSegments.add(r1);
            goto L16
        L12:
            r3 = false;
            goto L13
        }

        private final void removeAllCanonicalQueryParameters(String r7) {
            List<String> r0 = this.encodedQueryNamesAndValues;
            if (r0 != null) goto L5;
            Intrinsics.throwNpe();
        L5:
            IntProgression r1 = RangesKt.step(RangesKt.downTo(r0.size() - 2, 0), 2);
            int r2 = r1.getFirst();
            int r3 = r1.getLast();
            int r4 = r1.getStep();
            if (r4 < 0) goto L9;
            if (r2 <= r3) goto L10;
            return;
        L10:
            List<String> r5 = this.encodedQueryNamesAndValues;
            if (r5 != null) goto L14;
            Intrinsics.throwNpe();
        L14:
            if (Intrinsics.areEqual(r7, (String) ZeusTransformUtils.preCheckCast(r5.get(r2), String.class, "com.obric.memorydata.plugin")) == false) goto L28;
            List<String> r6 = this.encodedQueryNamesAndValues;
            if (r6 != null) goto L18;
            Intrinsics.throwNpe();
        L18:
            r6.remove(r2 + 1);
            List<String> r8 = this.encodedQueryNamesAndValues;
            if (r8 != null) goto L21;
            Intrinsics.throwNpe();
        L21:
            r8.remove(r2);
            List<String> r9 = this.encodedQueryNamesAndValues;
            if (r9 != null) goto L25;
            Intrinsics.throwNpe();
        L25:
            if (r9.isEmpty() == false) goto L28;
            this.encodedQueryNamesAndValues = (List) ZeusTransformUtils.preCheckCast(null, List.class, "com.obric.memorydata.plugin");
            return;
        L28:
            if (r2 == r3) goto L35;
            r2 = r2 + r4;
            goto L10
        L35:
            return;
        L9:
            if (r2 >= r3) goto L10;
        }

        private final void resolvePath(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r0 = r11.charAt(r12);
            if (r0 != '/') goto L7;
        L10:
            this.encodedPathSegments.clear();
            this.encodedPathSegments.add("");
            r12 = r12 + 1;
        L11:
            int r6 = r12;
            if (r6 >= r13) goto L20;
            r12 = Util.delimiterOffset(r11, "/\\", r6, r13);
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            push(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r12 = r12 + 1;
            goto L11
        L16:
            r1 = false;
            goto L17
        L20:
            return;
        L7:
            if (r0 == '\\') goto L10;
            List<String> r2 = this.encodedPathSegments;
            r2.set(r2.size() - 1, "");
            goto L11
        }

        public final Builder addEncodedPathSegment(String r10) {
            Intrinsics.checkParameterIsNotNull(r10, "encodedPathSegment");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).push(r10, 0, r10.length(), false, true);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addEncodedPathSegments(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "encodedPathSegments");
            return addPathSegments(r2, true);
        }

        public final Builder addEncodedQueryParameter(String r18, String r19) {
            Intrinsics.checkParameterIsNotNull(r18, "encodedName");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r15.encodedQueryNamesAndValues != null) goto L5;
            r15.encodedQueryNamesAndValues = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        L5:
            List<String> r14 = r15.encodedQueryNamesAndValues;
            if (r14 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            r14.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r18, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> r0 = r15.encodedQueryNamesAndValues;
            if (r0 != null) goto L11;
            Intrinsics.throwNpe();
        L11:
            if (r19 == null) goto L13;
            String r3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r19, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
        L14:
            r0.add(r3);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L13:
            r3 = null;
            goto L14
        }

        public final Builder addPathSegment(String r10) {
            Intrinsics.checkParameterIsNotNull(r10, "pathSegment");
            ((Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin")).push(r10, 0, r10.length(), false, false);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder addPathSegments(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "pathSegments");
            return addPathSegments(r2, false);
        }

        public final Builder addQueryParameter(String r18, String r19) {
            Intrinsics.checkParameterIsNotNull(r18, ActivityLifecycle.NAME);
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r15.encodedQueryNamesAndValues != null) goto L5;
            r15.encodedQueryNamesAndValues = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        L5:
            List<String> r14 = r15.encodedQueryNamesAndValues;
            if (r14 != null) goto L8;
            Intrinsics.throwNpe();
        L8:
            r14.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r18, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> r0 = r15.encodedQueryNamesAndValues;
            if (r0 != null) goto L11;
            Intrinsics.throwNpe();
        L11:
            if (r19 == null) goto L13;
            String r3 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r19, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
        L14:
            r0.add(r3);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L13:
            r3 = null;
            goto L14
        }

        public final HttpUrl build() {
            String r1 = this.scheme;
            if (r1 == null) goto L22;
            String r3 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
            String r4 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
            String r5 = this.host;
            if (r5 == null) goto L20;
            int r6 = effectivePort();
            String r11 = null;
            List r7 = Companion.percentDecode$default(HttpUrl.Companion, this.encodedPathSegments, false, 1, null);
            if (r7 == null) goto L18;
            List<String> r2 = this.encodedQueryNamesAndValues;
            if (r2 == null) goto L11;
            List r8 = Companion.access$percentDecode(HttpUrl.Companion, r2, true);
        L12:
            String r13 = this.encodedFragment;
            if (r13 == null) goto L16;
            r11 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, r13, 0, 0, false, 7, null);
        L16:
            return new HttpUrl(r1, r3, r4, r5, r6, r7, r8, r11, toString());
        L11:
            r8 = null;
            goto L12
        L18:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        L20:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("host == null"), Throwable.class, "com.obric.memorydata.plugin"));
        L22:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("scheme == null"), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder encodedFragment(String r17) {
            Builder r3 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L5;
            String r4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, "", true, false, false, true, null, 179, null);
        L6:
            r3.encodedFragment = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L5:
            r4 = null;
            goto L6
        }

        public final Builder encodedPassword(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, "encodedPassword");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r15.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder encodedPath(String r8) {
            Intrinsics.checkParameterIsNotNull(r8, "encodedPath");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (StringsKt.startsWith$default(r8, "/", false, 2, null) == false) goto L7;
            r2.resolvePath(r8, 0, r8.length());
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("unexpected encodedPath: " + r8).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder encodedQuery(String r17) {
            Builder r3 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L7;
            String r4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
            if (r4 == null) goto L7;
            List<String> r5 = HttpUrl.Companion.toQueryNamesAndValues$okhttp(r4);
        L8:
            r3.encodedQueryNamesAndValues = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            r5 = null;
            goto L8
        }

        public final Builder encodedUsername(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, "encodedUsername");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r15.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder fragment(String r17) {
            Builder r3 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L5;
            String r4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, "", false, false, false, true, null, 187, null);
        L6:
            r3.encodedFragment = r4;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L5:
            r4 = null;
            goto L6
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String r11) {
            Intrinsics.checkParameterIsNotNull(r11, "host");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            String r3 = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r11, 0, 0, false, 7, null));
            if (r3 == null) goto L7;
            r2.host = r3;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("unexpected host: " + r11), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder parse$okhttp(HttpUrl r30, String r31) {
            Intrinsics.checkParameterIsNotNull(r31, "input");
            int r1 = Util.indexOfFirstNonAsciiWhitespace$default(r31, 0, 0, 3, null);
            int r15 = Util.indexOfLastNonAsciiWhitespace$default(r31, r1, 0, 2, null);
            Companion r2 = Companion;
            int r4 = Companion.access$schemeDelimiterOffset(r2, r31, r1, r15);
            String r12 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            byte r11 = -1;
            String r10 = "com.obric.memorydata.plugin";
            boolean r9 = true;
            if (r4 != (-1)) goto L5;
            if (r30 == null) goto L87;
            this.scheme = r30.scheme();
        L14:
            int r3 = Companion.access$slashCount(r2, r31, r1, r15);
            byte r8 = Utf8.REPLACEMENT_BYTE;
            byte r7 = 35;
            if (r3 >= 2) goto L26;
            if (r30 == null) goto L26;
            if ((!Intrinsics.areEqual(r30.scheme(), this.scheme)) == true) goto L26;
            this.encodedUsername = r30.encodedUsername();
            this.encodedPassword = r30.encodedPassword();
            this.host = r30.host();
            this.port = r30.port();
            this.encodedPathSegments.clear();
            this.encodedPathSegments.addAll((Collection) ZeusTransformUtils.preCheckCast(r30.encodedPathSegments(), Collection.class, "com.obric.memorydata.plugin"));
            if (r1 != r15) goto L23;
        L24:
            encodedQuery(r30.encodedQuery());
        L25:
            int r19 = r15;
        L74:
            int r14 = r19;
            int r5 = Util.delimiterOffset(r31, "?#", r1, r14);
            resolvePath(r31, r1, r5);
            if (r5 < r14) goto L77;
        L79:
            if (r5 < r14) goto L81;
        L83:
            return this;
        L81:
            if (r31.charAt(r5) != '#') goto L83;
            this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r5 + 1, r14, "", true, false, false, true, null, 176, null);
            goto L83
        L77:
            if (r31.charAt(r5) != '?') goto L79;
            int r16 = Util.delimiterOffset(r31, '#', r5, r14);
            this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r5 + 1, r16, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
            r5 = r16;
            goto L79
        L23:
            if (r31.charAt(r1) != '#') goto L25;
        L26:
            int r6 = r1 + r3;
            boolean r17 = false;
            boolean r18 = false;
        L27:
            int r13 = Util.delimiterOffset(r31, "@/\\?#", r6, r15);
            if (r13 == r15) goto L30;
            byte r20 = r31.charAt(r13);
        L31:
            if (r20 == r11) goto L54;
            if (r20 == r7) goto L54;
            if (r20 == 47) goto L54;
            if (r20 == 92) goto L54;
            if (r20 == r8) goto L54;
            if (r20 == 64) goto L42;
            boolean r110 = r9;
            r10 = r10;
            String r21 = r12;
            r15 = r15;
        L53:
            r9 = r110;
            r15 = r15;
            r12 = r21;
            r10 = r10;
            r7 = 35;
            r8 = Utf8.REPLACEMENT_BYTE;
            r11 = -1;
            goto L27
        L42:
            if (r17 == true) goto L51;
            int r22 = Util.delimiterOffset(r31, ':', r6, r13);
            int r111 = r13;
            r110 = r9;
            String r112 = r12;
            String r23 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r6, r22, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            if (r18 == false) goto L46;
            r23 = this.encodedUsername + "%40" + r23;
        L46:
            this.encodedUsername = r23;
            if (r22 == r111) goto L49;
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r22 + 1, r111, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            boolean r24 = r110;
        L50:
            r17 = r24;
            r21 = r112;
            boolean r25 = r110;
        L52:
            r6 = r111 + 1;
            r18 = r25;
            goto L53
        L49:
            r24 = r17;
            goto L50
        L51:
            r111 = r13;
            r110 = r9;
            r21 = r12;
            this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r6, r111, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            r25 = r18;
        L54:
            boolean r113 = r9;
            String r28 = r10;
            String r26 = r12;
            r19 = r15;
            Companion r27 = Companion;
            int r29 = Companion.access$portColonOffset(r27, r31, r6, r13);
            int r114 = r29 + 1;
            if (r114 >= r13) goto L64;
            int r115 = r6;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r31, r6, r29, false, 4, null));
            int r32 = Companion.access$parsePort(r27, r31, r114, r13);
            this.port = r32;
            if (r32 == (-1)) goto L59;
            boolean r33 = r113;
        L60:
            if (r33 == true) goto L69;
            StringBuilder r0 = new StringBuilder().append("Invalid URL port: \"");
            String r34 = r31.substring(r114, r13);
            Intrinsics.checkExpressionValueIsNotNull(r34, r26);
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r0.append(r34).append(Typography.quote).toString().toString()), Throwable.class, r28));
        L69:
            if (this.host == null) goto L71;
            boolean r210 = r113;
        L72:
            if (r210 == false) goto L84;
            r1 = r13;
            goto L74
        L84:
            StringBuilder r35 = new StringBuilder().append("Invalid URL host: \"");
            String r36 = r31.substring(r115, r29);
            Intrinsics.checkExpressionValueIsNotNull(r36, r26);
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r35.append(r36).append(Typography.quote).toString().toString()), Throwable.class, r28));
        L71:
            r210 = false;
            goto L72
        L59:
            r33 = false;
            goto L60
        L64:
            r115 = r6;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r31, r115, r29, false, 4, null));
            Companion r37 = HttpUrl.Companion;
            String r38 = this.scheme;
            if (r38 != null) goto L67;
            Intrinsics.throwNpe();
        L67:
            this.port = r37.defaultPort(r38);
            goto L69
        L30:
            r20 = r11;
            goto L31
        L87:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found"), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            if (StringsKt.startsWith(r31, "https:", r1, true) == false) goto L8;
            this.scheme = LocationInfoConst.HTTPS;
            r1 = r1 + 6;
            goto L14
        L8:
            if (StringsKt.startsWith(r31, "http:", r1, true) == false) goto L10;
            this.scheme = "http";
            r1 = r1 + 5;
            goto L14
        L10:
            StringBuilder r39 = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
            String r40 = r31.substring(0, r4);
            Intrinsics.checkExpressionValueIsNotNull(r40, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(r39.append(r40).append("'").toString()), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final Builder password(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, "password");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r15.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder port(int r6) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            boolean r3 = true;
            if (1 <= r6) goto L6;
        L8:
            r3 = false;
        L9:
            if (r3 == false) goto L13;
            r2.port = r6;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L13:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("unexpected port: " + r6).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L6:
            if (65535 < r6) goto L8;
            goto L8
        }

        public final Builder query(String r17) {
            Builder r3 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r17 == null) goto L7;
            String r4 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
            if (r4 == null) goto L7;
            List<String> r5 = HttpUrl.Companion.toQueryNamesAndValues$okhttp(r4);
        L8:
            r3.encodedQueryNamesAndValues = r5;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L7:
            r5 = null;
            goto L8
        }

        public final Builder reencodeForUri$okhttp() {
            Builder r3 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            int r4 = r3.encodedPathSegments.size();
            int r5 = 0;
            int r6 = 0;
        L3:
            if (r6 >= r4) goto L5;
            r3.encodedPathSegments.set(r6, Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String) ZeusTransformUtils.preCheckCast(r3.encodedPathSegments.get(r6), String.class, "com.obric.memorydata.plugin"), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            r6 = r6 + 1;
            goto L3
        L5:
            List<String> r7 = r3.encodedQueryNamesAndValues;
            String r8 = null;
            if (r7 == null) goto L14;
            int r9 = r7.size();
        L8:
            if (r5 >= r9) goto L14;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r7.get(r5), String.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L12;
            String r11 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r10, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
        L13:
            r7.set(r5, r11);
            r5 = r5 + 1;
            goto L8
        L12:
            r11 = null;
        L14:
            String r12 = r3.encodedFragment;
            if (r12 == null) goto L17;
            r8 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r12, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
        L17:
            r3.encodedFragment = r8;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder removeAllEncodedQueryParameters(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, "encodedName");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r15.encodedQueryNamesAndValues != null) goto L5;
            return r15;
        L5:
            r15.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder removeAllQueryParameters(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, ActivityLifecycle.NAME);
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            if (r15.encodedQueryNamesAndValues != null) goto L5;
            return r15;
        L5:
            r15.removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder removePathSegment(int r5) {
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.encodedPathSegments.remove(r5);
            if (r2.encodedPathSegments.isEmpty() == false) goto L6;
            r2.encodedPathSegments.add("");
        L6:
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final Builder scheme(String r7) {
            Intrinsics.checkParameterIsNotNull(r7, "scheme");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            String r3 = "http";
            if (StringsKt.equals(r7, "http", true) == false) goto L5;
        L4:
            r2.scheme = r3;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L5:
            r3 = LocationInfoConst.HTTPS;
            if (StringsKt.equals(r7, LocationInfoConst.HTTPS, true) == true) goto L4;
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("unexpected scheme: " + r7), Throwable.class, "com.obric.memorydata.plugin"));
        }

        public final void setEncodedFragment$okhttp(String r1) {
            this.encodedFragment = r1;
        }

        public final void setEncodedPassword$okhttp(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.encodedPassword = r2;
        }

        public final Builder setEncodedPathSegment(int r18, String r19) {
            Intrinsics.checkParameterIsNotNull(r19, "encodedPathSegment");
            Builder r12 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            String r1 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r19, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            r12.encodedPathSegments.set(r18, r1);
            if (r12.isDot(r1) == false) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L12;
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L12:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("unexpected path segment: " + r19).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            if (r12.isDotDot(r1) == true) goto L7;
            r2 = true;
            goto L8
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> r3) {
            this.encodedQueryNamesAndValues = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        }

        public final Builder setEncodedQueryParameter(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, "encodedName");
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.removeAllEncodedQueryParameters(r4);
            r2.addEncodedQueryParameter(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setEncodedUsername$okhttp(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "<set-?>");
            this.encodedUsername = r2;
        }

        public final void setHost$okhttp(String r1) {
            this.host = r1;
        }

        public final Builder setPathSegment(int r18, String r19) {
            Intrinsics.checkParameterIsNotNull(r19, "pathSegment");
            Builder r12 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            String r1 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r19, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (r12.isDot(r1) == false) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L12;
            r12.encodedPathSegments.set(r18, r1);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        L12:
            throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(("unexpected path segment: " + r19).toString()), Throwable.class, "com.obric.memorydata.plugin"));
        L5:
            if (r12.isDotDot(r1) == true) goto L7;
            r2 = true;
            goto L8
        }

        public final void setPort$okhttp(int r1) {
            this.port = r1;
        }

        public final Builder setQueryParameter(String r4, String r5) {
            Intrinsics.checkParameterIsNotNull(r4, ActivityLifecycle.NAME);
            Builder r2 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r2.removeAllQueryParameters(r4);
            r2.addQueryParameter(r4, r5);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }

        public final void setScheme$okhttp(String r1) {
            this.scheme = r1;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.scheme;
            if (r1 == null) goto L5;
            r0.append(r1);
            String r2 = "://";
        L6:
            r0.append(r2);
            boolean r3 = true;
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.encodedUsername, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
            boolean r4 = true;
        L11:
            if (r4 == false) goto L13;
        L17:
            r0.append(this.encodedUsername);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.encodedPassword, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L21;
            r3 = false;
        L21:
            if (r3 == false) goto L23;
            r0.append(':');
            r0.append(this.encodedPassword);
        L23:
            r0.append('@');
        L24:
            String r5 = this.host;
            if (r5 == null) goto L33;
            if (r5 != null) goto L29;
            Intrinsics.throwNpe();
        L29:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == false) goto L31;
            r0.append('[');
            r0.append(this.host);
            r0.append(']');
            goto L33
        L31:
            r0.append(this.host);
        L33:
            if (this.port == (-1)) goto L35;
        L36:
            int r6 = effectivePort();
            if (this.scheme == null) goto L43;
            Companion r7 = HttpUrl.Companion;
            String r8 = this.scheme;
            if (r8 != null) goto L42;
            Intrinsics.throwNpe();
        L42:
            if (r6 != r7.defaultPort(r8)) goto L43;
        L44:
            HttpUrl.Companion.toPathString$okhttp(this.encodedPathSegments, r0);
            if (this.encodedQueryNamesAndValues == null) goto L51;
            r0.append('?');
            Companion r9 = HttpUrl.Companion;
            List<String> r10 = this.encodedQueryNamesAndValues;
            if (r10 != null) goto L49;
            Intrinsics.throwNpe();
        L49:
            r9.toQueryString$okhttp(r10, r0);
        L51:
            if (this.encodedFragment == null) goto L53;
            r0.append('#');
            r0.append(this.encodedFragment);
        L53:
            String r11 = r0.toString();
            Intrinsics.checkExpressionValueIsNotNull(r11, "StringBuilder().apply(builderAction).toString()");
            return r11;
        L43:
            r0.append(':');
            r0.append(r6);
            goto L44
        L35:
            if (this.scheme == null) goto L44;
        L13:
            if (((CharSequence) ZeusTransformUtils.preCheckCast(this.encodedPassword, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L15;
            boolean r12 = true;
        L16:
            if (r12 == false) goto L24;
        L15:
            r12 = false;
            goto L16
        L9:
            r4 = false;
            goto L11
        L5:
            r2 = "//";
            goto L6
        }

        public final Builder username(String r17) {
            Intrinsics.checkParameterIsNotNull(r17, "username");
            Builder r15 = (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
            r15.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r17, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return (Builder) ZeusTransformUtils.preCheckCast(this, Builder.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b+J&\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,2\b\b\u0002\u0010$\u001a\u00020\"H\u0002J\u0011\u0010-\u001a\u00020\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007¢\u0006\u0002\b\u0014J\u0013\u0010.\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u001bJ#\u0010/\u001a\u000200*\b\u0012\u0004\u0012\u00020\u00040,2\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u000200*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040,2\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b9JV\u0010:\u001a\u000200*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u000200*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", "uri", "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ List access$percentDecode(Companion r2, List r3, boolean r4) {
            return r2.percentDecode((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion r13, String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22, int r23, Object r24) {
            if ((r23 & 1) == 0) goto L5;
            int r5 = 0;
        L7:
            if ((r23 & 2) == 0) goto L9;
            int r6 = r14.length();
        L11:
            if ((r23 & 8) == 0) goto L13;
            boolean r8 = false;
        L15:
            if ((r23 & 16) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r23 & 32) == 0) goto L21;
            boolean r10 = false;
        L23:
            if ((r23 & 64) == 0) goto L25;
            boolean r11 = false;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Charset r12 = (Charset) ZeusTransformUtils.preCheckCast(null, Charset.class, "com.obric.memorydata.plugin");
        L31:
            return r13.canonicalize$okhttp(r14, r5, r6, r17, r8, r9, r10, r11, r12);
        L29:
            r12 = r22;
            goto L31
        L25:
            r11 = r21;
            goto L27
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }

        private final boolean isPercentEncoded(String r3, int r4, int r5) {
            int r2 = r4 + 2;
            if (r2 < r5) goto L5;
        L11:
            return false;
        L5:
            if (r3.charAt(r4) != '%') goto L11;
            if (Util.parseHexDigit(r3.charAt(r4 + 1)) == (-1)) goto L11;
            if (Util.parseHexDigit(r3.charAt(r2)) == (-1)) goto L11;
            return true;
        }

        private final List<String> percentDecode(List<String> r11, boolean r12) {
            List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            ArrayList r2 = new ArrayList(r13.size());
            Iterator r14 = r13.iterator();
        L4:
            if (r14.hasNext() == false) goto L10;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L8;
            String r0 = percentDecode$okhttp$default((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin"), r4, 0, 0, r12, 3, null);
        L9:
            r2.add(r0);
            goto L4
        L8:
            r0 = null;
            goto L9
        L10:
            List<String> r10 = Collections.unmodifiableList((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
            Intrinsics.checkExpressionValueIsNotNull(r10, "Collections.unmodifiableList(result)");
            return r10;
        }

        static /* synthetic */ List percentDecode$default(Companion r1, List r2, boolean r3, int r4, Object r5) {
            List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            if ((r4 & 1) == 0) goto L6;
            r3 = false;
        L6:
            return r1.percentDecode(r6, r3);
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion r1, String r2, int r3, int r4, boolean r5, int r6, Object r7) {
            if ((r6 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = r2.length();
        L9:
            if ((r6 & 4) == 0) goto L12;
            r5 = false;
        L12:
            return r1.percentDecode$okhttp(r2, r3, r4, r5);
        }

        private final void writeCanonicalized(Buffer r16, String r17, int r18, int r19, String r20, boolean r21, boolean r22, boolean r23, boolean r24, Charset r25) {
            Buffer r7 = (Buffer) ZeusTransformUtils.preCheckCast(null, Buffer.class, "com.obric.memorydata.plugin");
            int r4 = r18;
        L3:
            if (r4 >= r19) goto L57;
            if (r17 == null) goto L56;
            int r8 = r17.codePointAt(r4);
            if (r21 == false) goto L18;
            if (r8 == 9) goto L54;
            if (r8 == 10) goto L54;
            if (r8 == 12) goto L54;
            if (r8 != 13) goto L18;
        L54:
            r4 = r4 + Character.charCount(r8);
        L18:
            if (r8 != 43) goto L25;
            if (r23 == false) goto L25;
            if (r21 == false) goto L22;
            String r9 = Marker.ANY_NON_NULL_MARKER;
        L23:
            r16.writeUtf8(r9);
            goto L54
        L22:
            r9 = "%2B";
        L25:
            if (r8 < 32) goto L43;
            if (r8 == 127) goto L43;
            if (r8 < 128) goto L32;
            if (r24 == false) goto L43;
        L32:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"), (char) r8, false, 2, null) == true) goto L43;
            if (r8 != 37) goto L40;
            if (r21 == false) goto L43;
            if (r22 == false) goto L40;
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isPercentEncoded(r17, r4, r19) == false) goto L43;
        L40:
            r16.writeUtf8CodePoint(r8);
        L43:
            if (r7 != null) goto L45;
            r7 = new Buffer();
        L45:
            if (r25 != null) goto L47;
        L50:
            r7.writeUtf8CodePoint(r8);
        L52:
            if (r7.exhausted() == true) goto L54;
            int r10 = r7.readByte() & 255;
            r16.writeByte(37);
            r16.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[(r10 >> 4) & 15]);
            r16.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[r10 & 15]);
            goto L52
        L47:
            if (Intrinsics.areEqual(r25, StandardCharsets.UTF_8) == true) goto L50;
            r7.writeString(r17, r4, Character.charCount(r8) + r4, r25);
            goto L52
        L56:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        private final void writePercentDecoded(Buffer r5, String r6, int r7, int r8, boolean r9) {
        L2:
            if (r7 >= r8) goto L19;
            if (r6 == null) goto L18;
            int r4 = r6.codePointAt(r7);
            if (r4 != 37) goto L13;
            int r0 = r7 + 2;
            if (r0 >= r8) goto L13;
            int r1 = Util.parseHexDigit(r6.charAt(r7 + 1));
            int r2 = Util.parseHexDigit(r6.charAt(r0));
            if (r1 == (-1)) goto L16;
            if (r2 == (-1)) goto L16;
            r5.writeByte((r1 << 4) + r2);
            r7 = r0 + Character.charCount(r4);
        L16:
            r5.writeUtf8CodePoint(r4);
            r7 = r7 + Character.charCount(r4);
        L13:
            if (r4 != 43) goto L16;
            if (r9 == false) goto L16;
            r5.writeByte(32);
            r7 = r7 + 1;
            goto L2
        L18:
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2983deprecated_get(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2984deprecated_get(URI r3) {
            Intrinsics.checkParameterIsNotNull(r3, "uri");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2985deprecated_get(URL r3) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m2986deprecated_parse(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "url");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).parse(r3);
        }

        public final String canonicalize$okhttp(String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22) {
            Intrinsics.checkParameterIsNotNull(r14, "$this$canonicalize");
            Intrinsics.checkParameterIsNotNull(r17, "encodeSet");
            int r3 = r15;
        L3:
            if (r3 >= r16) goto L26;
            int r6 = r14.codePointAt(r3);
            if (r6 < 32) goto L24;
            if (r6 == 127) goto L24;
            if (r6 < 128) goto L12;
            if (r21 == false) goto L24;
        L12:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"), (char) r6, false, 2, null) == true) goto L24;
            if (r6 != 37) goto L20;
            if (r18 == false) goto L24;
            if (r19 == false) goto L20;
            if (((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).isPercentEncoded(r14, r3, r16) == false) goto L24;
        L20:
            if (r6 != 43) goto L23;
            if (r20 == true) goto L24;
        L23:
            r3 = r3 + Character.charCount(r6);
        L24:
            Buffer r11 = new Buffer();
            r11.writeUtf8(r14, r15, r3);
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).writeCanonicalized(r11, r14, r3, r16, r17, r18, r19, r20, r21, r22);
            return r11.readUtf8();
        L26:
            String r0 = r14.substring(r15, r16);
            Intrinsics.checkExpressionValueIsNotNull(r0, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return r0;
        }

        @JvmStatic
        public final int defaultPort(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "scheme");
            int r1 = r2.hashCode();
            if (r1 == 3213448) goto L11;
            if (r1 == 99617003) goto L8;
        L13:
            return -1;
        L8:
            if (r2.equals(LocationInfoConst.HTTPS) == false) goto L13;
            return UploadKeys.KeyIsGetVideoMeta;
        L11:
            if (r2.equals("http") == false) goto L13;
            return 80;
        }

        @JvmStatic
        public final HttpUrl get(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, r2).build();
        }

        @JvmStatic
        public final HttpUrl get(URI r3) {
            Intrinsics.checkParameterIsNotNull(r3, "$this$toHttpUrlOrNull");
            Companion r2 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin");
            String r4 = r3.toString();
            Intrinsics.checkExpressionValueIsNotNull(r4, "toString()");
            return r2.parse(r4);
        }

        @JvmStatic
        public final HttpUrl get(URL r3) {
            Intrinsics.checkParameterIsNotNull(r3, "$this$toHttpUrlOrNull");
            Companion r2 = (Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin");
            String r4 = r3.toString();
            Intrinsics.checkExpressionValueIsNotNull(r4, "toString()");
            return r2.parse(r4);
        }

        @JvmStatic
        public final HttpUrl parse(String r3) {
            Intrinsics.checkParameterIsNotNull(r3, "$this$toHttpUrlOrNull");
            return ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).get(r3);
        L5:
            return null;
        }

        public final String percentDecode$okhttp(String r8, int r9, int r10, boolean r11) {
            Intrinsics.checkParameterIsNotNull(r8, "$this$percentDecode");
            int r4 = r9;
        L3:
            if (r4 >= r10) goto L13;
            char r0 = r8.charAt(r4);
            if (r0 == '%') goto L11;
            if (r0 != '+') goto L10;
            if (r11 == true) goto L11;
        L10:
            r4 = r4 + 1;
        L11:
            Buffer r1 = new Buffer();
            r1.writeUtf8(r8, r9, r4);
            ((Companion) ZeusTransformUtils.preCheckCast(this, Companion.class, "com.obric.memorydata.plugin")).writePercentDecoded(r1, r8, r4, r10, r11);
            return r1.readUtf8();
        L13:
            String r7 = r8.substring(r9, r10);
            Intrinsics.checkExpressionValueIsNotNull(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return r7;
        }

        public final void toPathString$okhttp(List<String> r5, StringBuilder r6) {
            List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "$this$toPathString");
            Intrinsics.checkParameterIsNotNull(r6, "out");
            int r7 = r4.size();
            int r1 = 0;
        L3:
            if (r1 >= r7) goto L5;
            r6.append('/');
            r6.append((String) ZeusTransformUtils.preCheckCast(r4.get(r1), String.class, "com.obric.memorydata.plugin"));
            r1 = r1 + 1;
            goto L3
        }

        public final List<String> toQueryNamesAndValues$okhttp(String r11) {
            Intrinsics.checkParameterIsNotNull(r11, "$this$toQueryNamesAndValues");
            List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            int r0 = 0;
        L4:
            if (r0 > r11.length()) goto L15;
            int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), Typography.amp, r0, false, 4, null);
            if (r2 != (-1)) goto L8;
            r2 = r11.length();
        L8:
            int r9 = r2;
            int r3 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), '=', r0, false, 4, null);
            if (r3 == (-1)) goto L13;
            if (r3 > r9) goto L13;
            String r1 = r11.substring(r0, r3);
            Intrinsics.checkExpressionValueIsNotNull(r1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r10.add(r1);
            String r4 = r11.substring(r3 + 1, r9);
            Intrinsics.checkExpressionValueIsNotNull(r4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        L14:
            r10.add(r4);
            r0 = r9 + 1;
        L13:
            String r5 = r11.substring(r0, r9);
            Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r10.add(r5);
            r4 = null;
            goto L14
        L15:
            return r10;
        }

        public final void toQueryString$okhttp(List<String> r7, StringBuilder r8) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "$this$toQueryString");
            Intrinsics.checkParameterIsNotNull(r8, "out");
            IntProgression r9 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r6.size()), IntProgression.class, "com.obric.memorydata.plugin"), 2);
            int r1 = r9.getFirst();
            int r2 = r9.getLast();
            int r10 = r9.getStep();
            if (r10 < 0) goto L6;
            if (r1 <= r2) goto L7;
            return;
        L7:
            String r3 = (String) ZeusTransformUtils.preCheckCast(r6.get(r1), String.class, "com.obric.memorydata.plugin");
            String r4 = (String) ZeusTransformUtils.preCheckCast(r6.get(r1 + 1), String.class, "com.obric.memorydata.plugin");
            if (r1 <= 0) goto L10;
            r8.append(Typography.amp);
        L10:
            r8.append(r3);
            if (r4 == null) goto L13;
            r8.append('=');
            r8.append(r4);
        L13:
            if (r1 == r2) goto L19;
            r1 = r1 + r10;
            goto L7
        L19:
            return;
        L6:
            if (r1 >= r2) goto L7;
        }
    }

    static {
        Companion = new Companion(null);
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(String r3, String r4, String r5, String r6, int r7, List<String> r8, List<String> r9, String r10, String r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r3, "scheme");
        Intrinsics.checkParameterIsNotNull(r4, "username");
        Intrinsics.checkParameterIsNotNull(r5, "password");
        Intrinsics.checkParameterIsNotNull(r6, "host");
        Intrinsics.checkParameterIsNotNull(r12, "pathSegments");
        Intrinsics.checkParameterIsNotNull(r11, "url");
        this.scheme = r3;
        this.username = r4;
        this.password = r5;
        this.host = r6;
        this.port = r7;
        this.pathSegments = r12;
        this.queryNamesAndValues = r13;
        this.fragment = r10;
        this.url = r11;
        this.isHttps = Intrinsics.areEqual(r3, LocationInfoConst.HTTPS);
    }

    public static final /* synthetic */ char[] access$getHEX_DIGITS$cp() {
        return HEX_DIGITS;
    }

    @JvmStatic
    public static final int defaultPort(String r1) {
        return Companion.defaultPort(r1);
    }

    @JvmStatic
    public static final HttpUrl get(String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl get(URI r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl get(URL r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl parse(String r1) {
        return Companion.parse(r1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m2964deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m2965deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m2966deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m2967deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m2968deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m2969deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m2970deprecated_fragment() {
        return this.fragment;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m2971deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m2972deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m2973deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m2974deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m2975deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ChatMessage.TYPE_QUERY, imports = {}))
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m2976deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m2977deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m2978deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m2979deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m2980deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m2981deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m2982deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), '#', 0, false, 6, null) + 1;
        String r7 = this.url;
        if (r7 == null) goto L11;
        String r8 = r7.substring(r0);
        Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.String).substring(startIndex)");
        return r8;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedPassword() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.password, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), ':', this.scheme.length() + 3, false, 4, null) + 1;
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), '@', 0, false, 6, null);
        String r9 = this.url;
        if (r9 == null) goto L14;
        String r10 = r9.substring(r1, r2);
        Intrinsics.checkExpressionValueIsNotNull(r10, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r10;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        r0 = false;
        goto L6
    }

    public final String encodedPath() {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), '/', this.scheme.length() + 3, false, 4, null);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        String r7 = this.url;
        if (r7 == null) goto L7;
        String r8 = r7.substring(r0, r2);
        Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r8;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<String> encodedPathSegments() {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), '/', this.scheme.length() + 3, false, 4, null);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        List<String> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L3:
        if (r0 >= r2) goto L9;
        int r4 = r0 + 1;
        int r5 = Util.delimiterOffset(this.url, '/', r4, r2);
        String r6 = this.url;
        if (r6 == null) goto L8;
        String r7 = r6.substring(r4, r5);
        Intrinsics.checkExpressionValueIsNotNull(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r3.add(r7);
        r0 = r5;
        goto L3
    L8:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r3;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(this.url, CharSequence.class, "com.obric.memorydata.plugin"), '?', 0, false, 6, null) + 1;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, '#', r0, r1.length());
        String r7 = this.url;
        if (r7 == null) goto L11;
        String r8 = r7.substring(r0, r2);
        Intrinsics.checkExpressionValueIsNotNull(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r8;
    L11:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final String encodedUsername() {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.username, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r1 = this.scheme.length() + 3;
        String r2 = this.url;
        int r3 = Util.delimiterOffset(r2, ":@", r1, r2.length());
        String r4 = this.url;
        if (r4 == null) goto L14;
        String r5 = r4.substring(r1, r3);
        Intrinsics.checkExpressionValueIsNotNull(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r5;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L5:
        r0 = false;
        goto L6
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, HttpUrl.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((HttpUrl) ZeusTransformUtils.preCheckCast(r3, HttpUrl.class, "com.obric.memorydata.plugin")).url, this.url) == false) goto L7;
        return true;
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder r0 = new Builder();
        r0.setScheme$okhttp(this.scheme);
        r0.setEncodedUsername$okhttp(encodedUsername());
        r0.setEncodedPassword$okhttp(encodedPassword());
        r0.setHost$okhttp(this.host);
        if (this.port == Companion.defaultPort(this.scheme)) goto L5;
        int r1 = this.port;
    L6:
        r0.setPort$okhttp(r1);
        r0.getEncodedPathSegments$okhttp().clear();
        r0.getEncodedPathSegments$okhttp().addAll((Collection) ZeusTransformUtils.preCheckCast(encodedPathSegments(), Collection.class, "com.obric.memorydata.plugin"));
        r0.encodedQuery(encodedQuery());
        r0.setEncodedFragment$okhttp(encodedFragment());
        return r0;
    L5:
        r1 = -1;
        goto L6
    }

    public final Builder newBuilder(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "link");
        return new Builder().parse$okhttp(this, r2);
    L5:
        return null;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, r0);
        return r0.toString();
    }

    public final String queryParameter(String r8) {
        Intrinsics.checkParameterIsNotNull(r8, ActivityLifecycle.NAME);
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        IntProgression r1 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, r0.size()), IntProgression.class, "com.obric.memorydata.plugin"), 2);
        int r2 = r1.getFirst();
        int r4 = r1.getLast();
        int r3 = r1.getStep();
        if (r3 < 0) goto L9;
        if (r2 <= r4) goto L11;
    L16:
        return null;
    L11:
        if (Intrinsics.areEqual(r8, (String) ZeusTransformUtils.preCheckCast(this.queryNamesAndValues.get(r2), String.class, "com.obric.memorydata.plugin")) == true) goto L13;
        if (r2 == r4) goto L16;
        r2 = r2 + r3;
        goto L11
    L13:
        return (String) ZeusTransformUtils.preCheckCast(this.queryNamesAndValues.get(r2 + 1), String.class, "com.obric.memorydata.plugin");
    L9:
        if (r2 < r4) goto L16;
        goto L16
    }

    public final String queryParameterName(int r2) {
        List<String> r1 = this.queryNamesAndValues;
        if (r1 == null) goto L10;
        String r3 = r1.get(r2 * 2);
        if (r3 != null) goto L8;
        Intrinsics.throwNpe();
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IndexOutOfBoundsException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        IntProgression r1 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, this.queryNamesAndValues.size()), IntProgression.class, "com.obric.memorydata.plugin"), 2);
        int r2 = r1.getFirst();
        int r4 = r1.getLast();
        int r3 = r1.getStep();
        if (r3 < 0) goto L10;
        if (r2 <= r4) goto L11;
    L17:
        Set<String> r6 = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(r0, Set.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkExpressionValueIsNotNull(r6, "Collections.unmodifiableSet(result)");
        return r6;
    L11:
        String r5 = this.queryNamesAndValues.get(r2);
        if (r5 != null) goto L14;
        Intrinsics.throwNpe();
    L14:
        r0.add(r5);
        if (r2 == r4) goto L17;
        r2 = r2 + r3;
        goto L11
    L10:
        if (r2 < r4) goto L17;
    L5:
        return SetsKt.emptySet();
    }

    public final String queryParameterValue(int r2) {
        List<String> r1 = this.queryNamesAndValues;
        if (r1 == null) goto L7;
        return (String) ZeusTransformUtils.preCheckCast(r1.get((r2 * 2) + 1), String.class, "com.obric.memorydata.plugin");
    L7:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IndexOutOfBoundsException(), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final List<String> queryParameterValues(String r8) {
        Intrinsics.checkParameterIsNotNull(r8, ActivityLifecycle.NAME);
        if (this.queryNamesAndValues == null) goto L5;
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IntProgression r1 = RangesKt.step((IntProgression) ZeusTransformUtils.preCheckCast(RangesKt.until(0, this.queryNamesAndValues.size()), IntProgression.class, "com.obric.memorydata.plugin"), 2);
        int r3 = r1.getFirst();
        int r4 = r1.getLast();
        int r2 = r1.getStep();
        if (r2 < 0) goto L10;
        if (r3 <= r4) goto L12;
    L16:
        List<String> r7 = Collections.unmodifiableList(r0);
        Intrinsics.checkExpressionValueIsNotNull(r7, "Collections.unmodifiableList(result)");
        return r7;
    L12:
        if (Intrinsics.areEqual(r8, (String) ZeusTransformUtils.preCheckCast(this.queryNamesAndValues.get(r3), String.class, "com.obric.memorydata.plugin")) == false) goto L14;
        r0.add(this.queryNamesAndValues.get(r3 + 1));
    L14:
        if (r3 == r4) goto L16;
        r3 = r3 + r2;
        goto L12
    L10:
        if (r3 < r4) goto L16;
    L5:
        return CollectionsKt.emptyList();
    }

    public final int querySize() {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size() / 2;
    }

    public final String redact() {
        Builder r1 = newBuilder("/...");
        if (r1 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        return r1.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String r2) {
        Intrinsics.checkParameterIsNotNull(r2, "link");
        Builder r1 = newBuilder(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.build();
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host) == false) goto L6;
        return null;
    L6:
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    public final URI uri() {
        String r4 = newBuilder().reencodeForUri$okhttp().toString();
        return new URI(r4);
    L5:
        e = move-exception;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
        URI r6 = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(r5, ""));     // Catch: Exception -> L9
        Intrinsics.checkExpressionValueIsNotNull(r6, "URI.create(stripped)");     // Catch: Exception -> L9
        return r6;
    L10:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")), Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final String username() {
        return this.username;
    }
}
