package kotlin.io.path;

import androidx.exifinterface.media.ExifInterface;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\b\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\b¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0001\u001a4\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\b\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030 0\u001a\"\u0006\u0012\u0002\b\u00030 H\u0087\b¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\u0087\b\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\u0087\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\b\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\u0087\b\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\u0087\b\u001a.\u0010S\u001a\u000200*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\bø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\b\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\u0087\b\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\b\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\u0087\b\u001a\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u0002070\u001a\"\u000207H\u0087\b¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020:H\u0087\b\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\b\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\b\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\b¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\u0087\b\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\u0087\b\u001a\u001b\u0010\u007f\u001a\u00020\u0002*\u00020\u00022\f\u0010{\u001a\b\u0012\u0004\u0012\u00020b0aH\u0087\b\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\b\u001aF\u0010\u0082\u0001\u001a\u0003H\u0083\u0001\"\u0005\b\u0000\u0010\u0083\u0001*\u00020\u00022\b\b\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001\u0012\u0005\u0012\u0003H\u0083\u00010.H\u0087\bø\u0001\u0000¢\u0006\u0003\u0010\u0086\u0001\u001a3\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020,2\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\b\u0002\u0010\u008b\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\b1H\u0007\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\b\u0001\u0012\u00030\u008d\u00010\u001a\"\u00030\u008d\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008f\u0001"}, d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", SVGRenderEngine.PATH, "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1181:1\n1#2:1182\n1863#3,2:1183\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n440#1:1183,2\n*E\n"})
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Path(String r5) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        return Paths.get(r5, new String[0]);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path absolute(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toAbsolutePath();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final String absolutePathString(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path copyTo(Path r5, Path r10, boolean r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r11 == false) goto L5;
        CopyOption[] r12 = {StandardCopyOption.REPLACE_EXISTING};
    L7:
        return Files.copy(r5, r10, (CopyOption[]) Arrays.copyOf(r12, r12.length));
    L5:
        r12 = new CopyOption[0];
        goto L7
    }

    public static /* synthetic */ Path copyTo$default(Path r5, Path r10, boolean r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r11 == false) goto L8;
        CopyOption[] r14 = {StandardCopyOption.REPLACE_EXISTING};
    L10:
        return Files.copy(r5, r10, (CopyOption[]) Arrays.copyOf(r14, r14.length));
    L8:
        r14 = new CopyOption[0];
        goto L10
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createDirectories(Path r5, FileAttribute<?>... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attributes");
        return Files.createDirectories(r5, (FileAttribute[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createDirectory(Path r5, FileAttribute<?>... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attributes");
        return Files.createDirectory(r5, (FileAttribute[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createFile(Path r5, FileAttribute<?>... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attributes");
        return Files.createFile(r5, (FileAttribute[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createLinkPointingTo(Path r5, Path r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        return Files.createLink(r5, r10);
    }

    @SinceKotlin(version = "1.9")
    public static final Path createParentDirectories(Path r5, FileAttribute<?>... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Path r11 = r5.getParent();
        if (r11 != null) goto L5;
    L13:
        return r5;
    L5:
        if (Files.isDirectory(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        FileAttribute[] r12 = (FileAttribute[]) Arrays.copyOf(r10, r10.length);     // Catch: FileAlreadyExistsException -> L8
        Files.createDirectories(r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));     // Catch: FileAlreadyExistsException -> L8
    L8:
        e = move-exception;
        if (Files.isDirectory(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        throw e;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createSymbolicLinkPointingTo(Path r5, Path r10, FileAttribute<?>... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return Files.createSymbolicLink(r5, r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createTempDirectory(String r5, FileAttribute<?>... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r10, "attributes");
        return Files.createTempDirectory(r5, (FileAttribute[]) Arrays.copyOf(r10, r10.length));
    }

    public static /* synthetic */ Path createTempDirectory$default(String r5, FileAttribute[] r10, int r11, Object r12) throws IOException {
        if ((r11 & 1) == 0) goto L5;
        r5 = null;
    L5:
        Intrinsics.checkNotNullParameter(r10, "attributes");
        return Files.createTempDirectory(r5, (FileAttribute[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path createTempFile(String r5, String r10, FileAttribute<?>... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return Files.createTempFile(r5, r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
    }

    public static /* synthetic */ Path createTempFile$default(String r5, String r10, FileAttribute[] r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L6;
        r5 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r10 = null;
    L8:
        Intrinsics.checkNotNullParameter(r11, "attributes");
        return Files.createTempFile(r5, r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void deleteExisting(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Files.delete(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean deleteIfExists(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.deleteIfExists(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path div(Path r5, Path r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return r5.resolve(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean exists(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.exists(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @PublishedApi
    public static final Void fileAttributeViewNotAvailable(Path r5, Class<?> r10) {
        Intrinsics.checkNotNullParameter(r5, SVGRenderEngine.PATH);
        Intrinsics.checkNotNullParameter(r10, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + r10 + " is not available for the file " + r5 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        V r11 = (V) Files.getFileAttributeView(r5, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r10, r10.length));
        if (r11 == null) goto L5;
        return r11;
    L5:
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        fileAttributeViewNotAvailable(r5, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        return (V) Files.getFileAttributeView(r5, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final long fileSize(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.size(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileStore fileStore(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.getFileStore(r5);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> r5) {
        Intrinsics.checkNotNullParameter(r5, "builderAction");
        FileVisitorBuilderImpl r10 = new FileVisitorBuilderImpl();
        r5.invoke(r10);
        return r10.build();
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final void forEachDirectoryEntry(Path r5, String r10, Function1<? super Path, Unit> r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "glob");
        Intrinsics.checkNotNullParameter(r11, "action");
        DirectoryStream<Path> r12 = Files.newDirectoryStream(r5, r10);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L7
        Iterator<Path> r13 = r12.iterator();     // Catch: Throwable -> L7
    L5:
        if (r13.hasNext() == false) goto L9;
        r11.invoke(r13.next());     // Catch: Throwable -> L7
        goto L5
    L9:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L7
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L13;
        CloseableKt.closeFinally(r12, null);
    L15:
        InlineMarker.finallyEnd(1);
        return;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L24;
        if (r12 != null) goto L30;
    L25:
        InlineMarker.finallyEnd(1);
        throw th;
    L30:
        r12.close();     // Catch: Throwable -> L27
        goto L25
    L24:
        CloseableKt.closeFinally(r12, th);
        goto L25
    }

    public static /* synthetic */ void forEachDirectoryEntry$default(Path r5, String r10, Function1 r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = XPath.WILDCARD;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "glob");
        Intrinsics.checkNotNullParameter(r11, "action");
        DirectoryStream<Path> r14 = Files.newDirectoryStream(r5, r10);
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L10
        Iterator<Path> r15 = r14.iterator();     // Catch: Throwable -> L10
    L8:
        if (r15.hasNext() == false) goto L12;
        r11.invoke(r15.next());     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L16;
        CloseableKt.closeFinally(r14, null);
    L18:
        InlineMarker.finallyEnd(1);
        return;
    L16:
        if (r14 == null) goto L18;
        r14.close();
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L27;
        if (r14 != null) goto L33;
    L28:
        InlineMarker.finallyEnd(1);
        throw th;
    L33:
        r14.close();     // Catch: Throwable -> L30
        goto L28
    L27:
        CloseableKt.closeFinally(r14, th);
        goto L28
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Object getAttribute(Path r5, String r10, LinkOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attribute");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.getAttribute(r5, r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    public static final String getExtension(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Path r10 = r5.getFileName();
        if (r10 == null) goto L8;
        String r11 = r10.toString();
        if (r11 == null) goto L8;
        String r12 = StringsKt.T(r11);
        if (r12 == null) goto L8;
        return r12;
    L8:
        return "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getExtension$annotations(Path r5) {
    }

    private static final String getInvariantSeparatorsPath(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return getInvariantSeparatorsPathString(r5);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path r5) {
    }

    public static final String getInvariantSeparatorsPathString(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = r5.getFileSystem().getSeparator();
        boolean r11 = Intrinsics.areEqual(r10, "/");
        String r12 = r5.toString();
        if (r11 == true) goto L6;
        Intrinsics.checkNotNull(r10);
        return StringsKt.F(r12, r10, "/");
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path r5) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileTime getLastModifiedTime(Path r5, LinkOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.getLastModifiedTime(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    public static final String getName(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Path r10 = r5.getFileName();
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        if (r11 != null) goto L9;
        return "";
    L9:
        return r11;
    L5:
        r11 = null;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getName$annotations(Path r5) {
    }

    public static final String getNameWithoutExtension(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Path r10 = r5.getFileName();
        if (r10 == null) goto L8;
        String r11 = r10.toString();
        if (r11 == null) goto L8;
        String r12 = StringsKt.a0(r11, ".");
        if (r12 == null) goto L8;
        return r12;
    L8:
        return "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path r5) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final UserPrincipal getOwner(Path r5, LinkOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.getOwner(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    private static final String getPathString(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    public static /* synthetic */ void getPathString$annotations(Path r5) {
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Set<PosixFilePermission> getPosixFilePermissions(Path r5, LinkOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.getPosixFilePermissions(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isDirectory(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.isDirectory(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isExecutable(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.isExecutable(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isHidden(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.isHidden(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isReadable(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.isReadable(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isRegularFile(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.isRegularFile(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isSameFileAs(Path r5, Path r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return Files.isSameFile(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isSymbolicLink(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.isSymbolicLink(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isWritable(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.isWritable(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final List<Path> listDirectoryEntries(Path r5, String r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "glob");
        DirectoryStream<Path> r11 = Files.newDirectoryStream(r5, r10);
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L6
        List<Path> r12 = CollectionsKt.toList(r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r12;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path r5, String r10, int r11, Object r12) throws IOException {
        if ((r11 & 1) == 0) goto L6;
        r10 = XPath.WILDCARD;
    L6:
        return listDirectoryEntries(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path moveTo(Path r5, Path r10, CopyOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.move(r5, r10, (CopyOption[]) Arrays.copyOf(r11, r11.length));
    }

    public static /* synthetic */ Path moveTo$default(Path r5, Path r10, boolean r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L5;
        r11 = false;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r11 == false) goto L8;
        CopyOption[] r14 = {StandardCopyOption.REPLACE_EXISTING};
    L10:
        return Files.move(r5, r10, (CopyOption[]) Arrays.copyOf(r14, r14.length));
    L8:
        r14 = new CopyOption[0];
        goto L10
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean notExists(Path r5, LinkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return Files.notExists(r5, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path r5, LinkOption... r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        return (A) Files.readAttributes(r5, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path readSymbolicLink(Path r5) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Files.readSymbolicLink(r5);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeTo(Path r5, Path r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r5, r10);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r5 + "\nbase path: " + r10, e);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrNull(Path r5, Path r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r5, r10);
    L5:
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrSelf(Path r5, Path r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        Path r11 = relativeToOrNull(r5, r10);
        if (r11 != null) goto L6;
        return r5;
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setAttribute(Path r5, String r10, Object r11, LinkOption... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attribute");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.setAttribute(r5, r10, r11, (LinkOption[]) Arrays.copyOf(r12, r12.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setLastModifiedTime(Path r5, FileTime r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "value");
        return Files.setLastModifiedTime(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setOwner(Path r5, UserPrincipal r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "value");
        return Files.setOwner(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Path setPosixFilePermissions(Path r5, Set<? extends PosixFilePermission> r10) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "value");
        return Files.setPosixFilePermissions(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path toPath(URI r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return Paths.get(r5);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final <T> T useDirectoryEntries(Path r5, String r10, Function1<? super Sequence<? extends Path>, ? extends T> r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "glob");
        Intrinsics.checkNotNullParameter(r11, "block");
        DirectoryStream<Path> r12 = Files.newDirectoryStream(r5, r10);
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L11
        T r13 = r11.invoke(CollectionsKt.asSequence(r12));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L7;
        CloseableKt.closeFinally(r12, null);
    L9:
        InlineMarker.finallyEnd(1);
        return r13;
    L7:
        if (r12 == null) goto L9;
        r12.close();
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L19;
        if (r12 != null) goto L27;
    L20:
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        r12.close();     // Catch: Throwable -> L22
        goto L20
    L19:
        CloseableKt.closeFinally(r12, th);
        goto L20
    }

    public static /* synthetic */ Object useDirectoryEntries$default(Path r5, String r10, Function1 r11, int r12, Object r13) throws IOException {
        if ((r12 & 1) == 0) goto L5;
        r10 = XPath.WILDCARD;
    L5:
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "glob");
        Intrinsics.checkNotNullParameter(r11, "block");
        DirectoryStream<Path> r14 = Files.newDirectoryStream(r5, r10);
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L14
        Object r15 = r11.invoke(CollectionsKt.asSequence(r14));     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L10;
        CloseableKt.closeFinally(r14, null);
    L12:
        InlineMarker.finallyEnd(1);
        return r15;
    L10:
        if (r14 == null) goto L12;
        r14.close();
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        InlineMarker.finallyStart(1);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == true) goto L22;
        if (r14 != null) goto L26;
    L23:
        InlineMarker.finallyEnd(1);
        throw th;
    L26:
        r14.close();     // Catch: Throwable -> L25
        goto L23
    L22:
        CloseableKt.closeFinally(r14, th);
        goto L23
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(Path r5, FileVisitor<Path> r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "visitor");
        if (r12 == false) goto L5;
        Set r13 = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    L6:
        Files.walkFileTree(r5, r13, r11, r10);
        return;
    L5:
        r13 = SetsKt.emptySet();
        goto L6
    }

    public static /* synthetic */ void visitFileTree$default(Path r5, FileVisitor r10, int r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = Integer.MAX_VALUE;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = false;
    L8:
        visitFileTree(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final Sequence<Path> walk(Path r5, PathWalkOption... r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "options");
        return new PathTreeWalk(r5, r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Path(String r5, String... r10) {
        Intrinsics.checkNotNullParameter(r5, "base");
        Intrinsics.checkNotNullParameter(r10, "subpaths");
        return Paths.get(r5, (String[]) Arrays.copyOf(r10, r10.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempDirectory(Path r5, String r10, FileAttribute<?>... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "attributes");
        if (r5 == null) goto L6;
        return Files.createTempDirectory(r5, r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
    L6:
        return Files.createTempDirectory(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempFile(Path r5, String r10, String r11, FileAttribute<?>... r12) throws IOException {
        Intrinsics.checkNotNullParameter(r12, "attributes");
        if (r5 == null) goto L6;
        return Files.createTempFile(r5, r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
    L6:
        return Files.createTempFile(r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path div(Path r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return r5.resolve(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path moveTo(Path r5, Path r10, boolean r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        if (r11 == false) goto L5;
        CopyOption[] r12 = {StandardCopyOption.REPLACE_EXISTING};
    L7:
        return Files.move(r5, r10, (CopyOption[]) Arrays.copyOf(r12, r12.length));
    L5:
        r12 = new CopyOption[0];
        goto L7
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    private static final Map<String, Object> readAttributes(Path r5, String r10, LinkOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "attributes");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.readAttributes(r5, r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    public static /* synthetic */ void visitFileTree$default(Path r5, int r10, boolean r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = Integer.MAX_VALUE;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = false;
    L8:
        visitFileTree(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path copyTo(Path r5, Path r10, CopyOption... r11) throws IOException {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "target");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.copy(r5, r10, (CopyOption[]) Arrays.copyOf(r11, r11.length));
    }

    public static /* synthetic */ Path createTempDirectory$default(Path r5, String r10, FileAttribute[] r11, int r12, Object r13) throws IOException {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        return createTempDirectory(r5, r10, r11);
    }

    public static /* synthetic */ Path createTempFile$default(Path r5, String r10, String r11, FileAttribute[] r12, int r13, Object r14) throws IOException {
        if ((r13 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r11 = null;
    L9:
        return createTempFile(r5, r10, r11, r12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(Path r5, int r10, boolean r11, Function1<? super FileVisitorBuilder, Unit> r12) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r12, "builderAction");
        visitFileTree(r5, fileVisitor(r12), r10, r11);
    }
}
